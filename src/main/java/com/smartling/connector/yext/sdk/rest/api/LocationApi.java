package com.smartling.connector.yext.sdk.rest.api;

import com.smartling.connector.yext.sdk.data.Location;
import com.smartling.connector.yext.sdk.data.response.EmptyResponse;
import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface LocationApi
{
    @RequestLine("GET /accounts/me/locationsearch?access_token={access_token}&v={v}&limit={limit}&offset={offset}&filters={filters}&field={fields}")
    LocationsResponse searchLocations(@Param("access_token") String accessToken, @Param("v") String v,
            @Param("limit") Integer limit, @Param("offset") Integer offset, @Param("filters") String filters);

    @RequestLine("GET /accounts/me/locations/{locationId}?access_token={access_token}&v={v}")
    LocationResponse getLocation(@Param("locationId") String locationId, @Param("access_token") String accessToken, @Param("v") String v);

    @RequestLine("GET /accounts/me/locations/{locationId}/profiles/{languageCode}?access_token={access_token}&v={v}")
    LocationResponse getLocationProfile(@Param("locationId") String locationId, @Param("access_token") String accessToken, @Param("v") String v, @Param("languageCode") String languageCode);

    @RequestLine("GET /accounts/me/locations/{locationId}/profiles?access_token={access_token}&v={v}")
    LocationProfilesResponse listLocationProfiles(@Param("locationId") String locationId, @Param("access_token") String accessToken, @Param("v") String v);

    @RequestLine("PUT /accounts/me/locations/{locationId}/profiles/{language_code}?access_token={access_token}&v={v}")
    @Headers ("Content-Type: application/json")
    EmptyResponse upsertLanguageProfile(@Param("locationId") String locationId, @Param("language_code") String languageCode, @Param("v") String v,
            @Param("access_token") String accessToken, Location locationLanguageProfile);
}
