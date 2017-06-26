package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.CustomFieldsClient;
import com.smartling.connector.yext.sdk.client.LocationClient;
import com.smartling.connector.yext.sdk.client.MenuClient;
import com.smartling.connector.yext.sdk.data.Location;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import org.junit.Before;

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

    public static Location getYextMainLocation(LocationClient client)
    {
        LocationsResponse locationsResponse = client.searchLocations(0, 50, "main");
        assertThat(locationsResponse).isNotNull();
        assertThat(locationsResponse.getResponse().getCount())
                .as("It is need to have at least one location with a 'main' substring in the name")
                .isGreaterThan(0);

        return first(locationsResponse.getResponse().getLocations());
    }

}
