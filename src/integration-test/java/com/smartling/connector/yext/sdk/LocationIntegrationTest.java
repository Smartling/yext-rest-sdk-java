package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.LocationClient;
import com.smartling.connector.yext.sdk.data.Location;
import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationIntegrationTest extends BaseIntegrationTest
{
//    @Test
//    public void testOAuthFlow()
//    {
//        String code = "dec38e50f384439e840ca83bc993c5d1";
//        LoginClient loginClient = new LoginClient(configuration, code);
//        TokenInfo tokenInfo = loginClient.getTokenInfo();
//        System.out.println("tokenInfo.getAccessToken()" + tokenInfo.getAccessToken());
//
//        assertThat(tokenInfo.getAccessToken()).isNotNull();
//        assertThat(tokenInfo.getAccessToken()).isNotEmpty();
//    }

    @Test
    public void basicIntegrationTest()
    {
        LocationClient locationClient = new LocationClient(configuration, accessToken);

        final LocationsResponse locationsResponse = locationClient.searchLocations(50, 0, "main");
        assertThat(locationsResponse).isNotNull();
        assertThat(locationsResponse.getResponse().getCount()).isGreaterThan(0);

        String yextMainLocationId = locationsResponse.getResponse().getLocations().get(0).getId();
        final LocationResponse locationResponse = locationClient.getLocationById(yextMainLocationId);
        assertThat(locationResponse.getResponse()).isNotNull();
        assertThat(locationResponse.getResponse().getId()).isNotNull();

        final LocationProfilesResponse locationProfileResponse = locationClient.listLocationProfile(yextMainLocationId);
        assertThat(locationProfileResponse.getResponse()).isNotNull();
        assertThat(locationProfileResponse.getResponse().getLanguageProfiles()).isNotNull();

        final LocationResponse locationProfiles = locationClient.getLocationProfile(yextMainLocationId, "de");
        final Location location = locationProfiles.getResponse();
        assertThat(location).isNotNull();
        assertThat(location.getId()).isNotNull();

        location.setFeaturedMessage("Used in integration tests");
        locationClient.upsertLocationLanguageProfile(yextMainLocationId, "de", location);
    }
}
