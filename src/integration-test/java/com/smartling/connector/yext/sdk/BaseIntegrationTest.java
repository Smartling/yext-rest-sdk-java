package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.CustomFieldsClient;
import com.smartling.connector.yext.sdk.client.LocationClient;
import com.smartling.connector.yext.sdk.client.MenuClient;
import com.smartling.connector.yext.sdk.client.ProductClient;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import com.smartling.connector.yext.sdk.data.response.location.Filters;
import com.smartling.connector.yext.sdk.data.response.location.Location;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

import static com.smartling.connector.yext.sdk.utils.CollectionUtils.first;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;


public class BaseIntegrationTest
{

    private TimeoutConfiguration timeoutConfiguration;

    private String accessToken;

    @Before
    public void setUp() throws Exception
    {
        accessToken = System.getProperty("yext.accessToken");
        assertNotNull("accessToken is not specified", accessToken);

        this.timeoutConfiguration = new TimeoutConfiguration();
    }

    public MenuClient menuClient()
    {
        return new MenuClient(timeoutConfiguration, accessToken);
    }

    public LocationClient locationClient()
    {
        return new LocationClient(timeoutConfiguration, accessToken);
    }

    public CustomFieldsClient customFieldsClient()
    {
        return new CustomFieldsClient(timeoutConfiguration, accessToken);
    }

    public ProductClient productClient()
    {
        return new ProductClient(timeoutConfiguration, accessToken);
    }

    public static Location getYextMainLocation(LocationClient client)
    {
        Filters filters = new Filters();
        filters.setFilters(Arrays.asList(new Filters.Filter("name", Arrays.asList("main"), Filters.Matcher.CONTAINS)));
        LocationsResponse locationsResponse = client.searchLocations(0, 50, filters, new ArrayList<>());
        assertThat(locationsResponse).isNotNull();
        assertThat(locationsResponse.getResponse().getCount())
                .as("It is need to have at least one location with a 'main' substring in the name")
                .isGreaterThan(0);

        return first(locationsResponse.getResponse().getEntities());
    }

}
