package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.response.IdResponse;
import com.smartling.connector.yext.sdk.data.response.product.Product;
import com.smartling.connector.yext.sdk.data.response.product.ProductResponse;
import com.smartling.connector.yext.sdk.data.response.product.ProductsResponse;
import com.smartling.connector.yext.sdk.rest.api.ProductApi;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.generateV;

public class ProductClient extends ApiClient
{

    private ProductApi productApi;

    public ProductClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        super(timeoutConfiguration, accessToken);
        productApi = buildApiWithOAuthAuthentication(ProductApi.class, BASE_API_URL);
    }

    public IdResponse createProduct(Product product)
    {
        return productApi.createProduct(accessToken, generateV(), product);
    }

    public void updateProduct(String productId, Product product)
    {
        productApi.updateProduct(accessToken, generateV(), productId, product);
    }

    public ProductResponse getProductById(String productId)
    {
        return productApi.getProductById(accessToken, generateV(), productId);
    }

    public ProductsResponse listProduct(int offset, int limit)
    {
        return productApi.listProduct(accessToken, generateV(), offset, limit);
    }

    /**
     * This method throws an exception for HTTP errors.
     */
    public void deleteProductById(String productId)
    {
        productApi.deleteProductById(accessToken, generateV(), productId);
    }

}
