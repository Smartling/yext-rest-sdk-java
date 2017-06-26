package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.LocationClient;
import com.smartling.connector.yext.sdk.data.Location;
import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationIntegrationTest extends BaseIntegrationTest
{
//    @Test
//    public void testOAuthFlow()
//    {
//        String code = "dec38e50f384439e840ca83bc993c5d1";
//        LoginClient loginClient = new LoginClient(timeoutConfiguration, code);
//        TokenInfo tokenInfo = loginClient.getTokenInfo();
//        System.out.println("tokenInfo.getAccessToken()" + tokenInfo.getAccessToken());
//
//        assertThat(tokenInfo.getAccessToken()).isNotNull();
//        assertThat(tokenInfo.getAccessToken()).isNotEmpty();
//    }

    @Test
    public void basicIntegrationTest()
    {
        LocationClient locationClient = locationClient();

        String yextMainLocationId = getYextMainLocation(locationClient).getId();
        final LocationResponse locationResponse = locationClient.getLocationById(yextMainLocationId);
        assertThat(locationResponse.getResponse()).isNotNull();
        assertThat(locationResponse.getResponse().getId()).isNotNull();

        final LocationProfilesResponse locationProfileResponse = locationClient.listLocationProfile(yextMainLocationId);
        assertThat(locationProfileResponse.getResponse()).isNotNull();
        assertThat(locationProfileResponse.getResponse().getLanguageProfiles()).isNotNull();

        final LocationResponse locationProfiles = locationClient.getLocationProfile(yextMainLocationId, "en");
        final Location location = locationProfiles.getResponse();
        assertThat(location).isNotNull();
        assertThat(location.getId()).isNotNull();

        location.setLanguage("de");
        location.setFeaturedMessage("Used in integration tests");
        locationClient.upsertLocationLanguageProfile(yextMainLocationId, "de", location);
    }

}
