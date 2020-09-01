package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.LocationClient;
import com.smartling.connector.yext.sdk.client.ProductClient;
import com.smartling.connector.yext.sdk.data.response.location.Location;
import com.smartling.connector.yext.sdk.data.response.IdResponse;
import com.smartling.connector.yext.sdk.data.response.product.ListProducts;
import com.smartling.connector.yext.sdk.data.response.product.Product;
import com.smartling.connector.yext.sdk.data.response.product.ProductResponse;
import com.smartling.connector.yext.sdk.data.response.product.ProductsResponse;
import com.smartling.connector.yext.sdk.rest.YextRestException;
import com.smartling.connector.yext.sdk.utils.JsonUtils;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.smartling.connector.yext.sdk.utils.CollectionUtils.first;
import static com.smartling.connector.yext.sdk.utils.CollectionUtils.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductIntegrationTest extends BaseIntegrationTest
{

    @Test
    public void createProduct()
    {
        ProductClient client = productClient();
        Product product = createProduct(client);
        client.deleteProductById(product.getId());
    }

    @Test
    public void updateProduct()
    {
        ProductClient client = productClient();

        Product expectedProduct = createProduct(client);
        String productId = expectedProduct.getId();
        expectedProduct.setName("updated " + expectedProduct.getName());
        expectedProduct.setTitle("updated " + expectedProduct.getTitle());

        client.updateProduct(productId, expectedProduct);

        Product actualProduct = getProductById(client, productId);
        assertFields(actualProduct, expectedProduct);

        client.deleteProductById(expectedProduct.getId());
    }

    @Test
    public void getProductById()
    {
        ProductClient client = productClient();

        Product expected = createProduct(client);

        Product actual = getProductById(client, expected.getId());
        assertThat(actual.getId()).isNotNull();
        assertFields(actual, expected);

        client.deleteProductById(expected.getId());
    }

    @Test
    public void listProduct()
    {
        getProductsList(productClient());
    }

    @Test
    public void deleteProductById()
    {
        ProductClient client = productClient();

        Product product = createProduct(client);
        client.deleteProductById(product.getId());

        assertThatThrownBy(() -> client.deleteProductById(product.getId()))
                .isInstanceOf(YextRestException.class)
                .hasMessageContaining("404");
    }

    @Test
    public void cloneProductForLanguage() throws InterruptedException
    {
        ProductClient client = productClient();
        LocationClient locationClient = locationClient();

        Product srcProduct = createProduct(client);
        String srcProductId = srcProduct.getId();
        generateFields(srcProduct);

        Location yextMainLocation = getYextMainLocation(locationClient);

        // update default English profile for English product
        locationClient.updateLocationProfileForProduct(yextMainLocation, srcProduct.getId(), srcProduct.getLanguage());

        // to search locations, without this delay just updated locations can't be found
        TimeUnit.SECONDS.sleep(10);
        final int offset = 0;
        final int limit = 50;
        List<Location> srcLocations = locationClient.searchLocationsByProductId(offset, limit, srcProduct.getId())
                .getResponse().getEntities();

        assertThat(srcLocations).hasSize(1);
        assertThat(first(srcLocations).getMeta().getId()).isEqualTo(yextMainLocation.getMeta().getId());

        srcProduct.setId(null);
        String langCode = changeLang(srcProduct.getLanguage());
        srcProduct.setLanguage(langCode);

        String clonedId = client.createProduct(srcProduct).getIdAsString();

        stream(srcLocations).forEach(enLocation ->
        {
            Location langProfile = locationClient.getLocationProfile(
                    enLocation.getMeta().getId(), langCode
            ).getResponse();
            locationClient.updateLocationProfileForProduct(langProfile, clonedId, langCode);
        });

        Location withClonedProduct = locationClient
                .getLocationProfile(yextMainLocation.getMeta().getId(), langCode).getResponse();

        assertThat(withClonedProduct.getProductLists().getIds()).contains(clonedId);

        client.deleteProductById(srcProductId);
        client.deleteProductById(clonedId);
    }

    // to check API
    //@Test
    public void cloneExistingProductForLanguage() throws InterruptedException
    {
        ProductClient client = productClient();
        LocationClient locationClient = locationClient();

        final String srcProductId = "585693";

        final String langCode = "es";

        Product srcProduct = client.getProductById(srcProductId).getResponse();
        srcProduct.setId(null);
        setNameAndTitle(srcProduct, srcProduct.getTitle() + " " + generateName() + " " + langCode);
        srcProduct.setLanguage(langCode);

        String clonedId = client.createProduct(srcProduct).getIdAsString();

        final int offset = 0;
        final int limit = 50;
        List<Location> srcLocations = locationClient.searchLocationsByProductId(offset, limit, srcProductId)
                .getResponse().getEntities();

        stream(srcLocations).forEach(enLocation ->
        {
            Location langProfile = locationClient.getLocationProfile(
                    enLocation.getMeta().getId(), langCode
            ).getResponse();

            locationClient.updateLocationProfileForProduct(langProfile, clonedId, langCode);
        });
    }

    // to check API
    //@Test
    public void getExistingProductById() throws InterruptedException
    {
        ProductClient client = productClient();

        final String productId = "585693";

        Product product = client.getProductById(productId).getResponse();

        System.out.println(JsonUtils.toJsonStringIgnorePropertyAccess(product));
    }

    private static String changeLang(String prevLang)
    {
        return prevLang.equals("en") ? "es" : "en";
    }


    private static Product getProductById(ProductClient client, String id)
    {
        assertThat(id).isNotEmpty();
        ProductResponse productResponse = client.getProductById(id);
        assertThat(productResponse).isNotNull();

        Product result = productResponse.getResponse();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        return result;
    }

    private static Product createProduct(ProductClient client)
    {
        Product newProduct = newProduct();
        generateFields(newProduct);

        IdResponse idResponse = client.createProduct(newProduct);
        assertThat(idResponse).isNotNull();

        Product createdProduct = getProductById(client, idResponse.getIdAsString());
        assertFields(createdProduct, newProduct);

        return createdProduct;
    }

    private static ListProducts getProductsList(ProductClient client)
    {
        final int offset = 0;
        final int limit = 50;
        ProductsResponse productsResponse = client.listProduct(offset, limit);
        assertThat(productsResponse).isNotNull();

        ListProducts result = productsResponse.getResponse();
        assertThat(result).isNotNull();
        assertThat(result.getCount()).isGreaterThan(0);
        assertThat(result.getProducts()).isNotEmpty();

        return result;
    }

    private static void assertFields(Product actual, Product expected)
    {
        assertThat(expected).isNotNull();
        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
    }

    private static void generateFields(Product product)
    {
        final String name = generateName();
        setNameAndTitle(product, name);
    }

    private static void setNameAndTitle(Product product, String name)
    {
        product.setName(name);
        product.setTitle(name);
    }

    private static String generateName()
    {
        return "test " + System.currentTimeMillis();
    }

    private static Product newProduct()
    {
        return JsonUtils.fromJsonByClassLoader("json/create_product.json", Product.class);
    }

}
