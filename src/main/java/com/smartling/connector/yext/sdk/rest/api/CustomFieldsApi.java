package com.smartling.connector.yext.sdk.rest.api;

import com.smartling.connector.yext.sdk.data.response.customfields.CustomFieldsResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.ACCEPT_APPLICATION_JSON;

@Headers(ACCEPT_APPLICATION_JSON)
public interface CustomFieldsApi
{

    @RequestLine("GET /accounts/me/customfields?access_token={access_token}&v={v}&limit={limit}&offset={offset}")
    CustomFieldsResponse listCustomFields(@Param("access_token") String accessToken, @Param("v") String v,
                                          @Param("offset") Integer offset, @Param("limit") Integer limit);

}
