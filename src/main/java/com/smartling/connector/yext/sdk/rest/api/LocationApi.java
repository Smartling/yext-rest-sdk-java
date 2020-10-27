package com.smartling.connector.yext.sdk.rest.api;

import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import com.smartling.connector.yext.sdk.data.response.location.Location;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.ACCEPT_APPLICATION_JSON;
import static com.smartling.connector.yext.sdk.utils.RestApiUtils.CONTENT_TYPE_APPLICATION_JSON;

@Headers(ACCEPT_APPLICATION_JSON)
public interface LocationApi
{
    @RequestLine("GET /accounts/me/entities?entityTypes=location&access_token={access_token}&v={v}&limit={limit}&offset={offset}&filter={filters}&sortBy={sortBy}")
    LocationsResponse searchLocations(@Param("access_token") String accessToken,
                                      @Param("v") String v,
                                      @Param("limit") Integer limit,
                                      @Param("offset") Integer offset,
                                      @Param("filters") String filters,
                                      @Param("sortBy") String sortBy);

    @RequestLine("GET /accounts/me/entities/{entityId}?access_token={access_token}&v={v}")
    LocationResponse getLocation(@Param("entityId") String entityId, @Param("access_token") String accessToken, @Param("v") String v);

    @RequestLine("GET /accounts/me/entityprofiles/{entityId}/{languageCode}?access_token={access_token}&v={v}")
    LocationResponse getLanguageProfile(@Param("entityId") String entityId, @Param("access_token") String accessToken, @Param("v") String v, @Param("languageCode") String languageCode);

    @RequestLine("GET /accounts/me/entityprofiles/{entityId}?access_token={access_token}&v={v}")
    LocationProfilesResponse listLanguageProfiles(@Param("entityId") String entityId, @Param("access_token") String accessToken, @Param("v") String v);

    @RequestLine("PUT /accounts/me/entityprofiles/{entityId}/{language_code}?access_token={access_token}&v={v}")
    @Headers(CONTENT_TYPE_APPLICATION_JSON)
    void upsertLanguageProfile(@Param("entityId") String entityId, @Param("language_code") String languageCode, @Param("v") String v,
                                        @Param("access_token") String accessToken, Location entityLanguageProfile);
}
