package com.smartling.connector.yext.sdk;

import com.google.common.collect.Maps;
import com.smartling.connector.yext.sdk.client.LocationClient;
import com.smartling.connector.yext.sdk.data.response.location.FeaturedMessage;
import com.smartling.connector.yext.sdk.data.response.location.Location;
import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import com.smartling.connector.yext.sdk.utils.JsonUtils;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

        String yextMainLocationId = getYextMainLocation(locationClient).getMeta().getId();
        final LocationResponse locationResponse = locationClient.getLocationById(yextMainLocationId);
        assertThat(locationResponse.getResponse()).isNotNull();
        assertThat(locationResponse.getResponse().getMeta().getId()).isNotNull();

        final LocationProfilesResponse locationProfileResponse = locationClient.listLocationProfile(yextMainLocationId);
        assertThat(locationProfileResponse.getResponse()).isNotNull();
        assertThat(locationProfileResponse.getResponse().getProfiles()).isNotNull();

        final LocationResponse locationProfiles = locationClient.getLocationProfile(yextMainLocationId, "en");
        final Location location = locationProfiles.getResponse();
        assertThat(location).isNotNull();
        assertThat(location.getMeta().getId()).isNotNull();

        location.setFeaturedMessage(new FeaturedMessage("Used in integration tests", null));
        location.getCustomFields().remove("c_textList", "textList");

        locationClient.upsertLocationLanguageProfile(yextMainLocationId, "de", location);
    }

    // to check API
    // @Test
    public void customFieldsTest()
    {
        LocationClient locationClient = locationClient();
        Location locationPrimary = getYextMainLocation(locationClient);

        final String photoId = "15875";
        LinkedHashMap<String, String> photoObject =
                (LinkedHashMap<String, String>) locationPrimary.getCustomFields().get(photoId);

        final String galeryId = "15874";
        List<LinkedHashMap<String, String>> galeryObject =
                (List<LinkedHashMap<String, String>>) locationPrimary.getCustomFields().get(galeryId);

        System.out.println(photoObject);
        System.out.println(JsonUtils.toJsonString(photoObject));

        System.out.println(galeryObject);
        System.out.println(JsonUtils.toJsonString(galeryObject));

        Location locationEs = new Location();
        Map<String, Object> fields = Maps.newHashMap();

        LinkedHashMap<String, String> newPhotoObject = Maps.newLinkedHashMap();
        newPhotoObject.put("description", "translated description photo new");
        newPhotoObject.put("url", photoObject.get("url"));
        fields.put(photoId, newPhotoObject);

        galeryObject.forEach(photo -> photo.put("description", "translated description galery"));
        fields.put(galeryId, galeryObject);

        locationEs.setCustomFields(fields);

        locationClient.upsertLocationLanguageProfile(locationPrimary.getMeta().getId(), "es", locationEs);
    }

}
