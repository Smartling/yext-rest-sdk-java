package com.smartling.connector.yext.sdk.rest.api;

import com.smartling.connector.yext.sdk.data.TokenInfo;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface LoginApi
{
    @RequestLine("POST /oauth2/accesstoken")
    @Headers ("Content-Type: application/x-www-form-urlencoded")
    TokenInfo getTokenInfo(@Param("client_id") String clientId,@Param("client_secret") String clientSecret, @Param("redirect_uri") String redirectUri, @Param("grant_type") String grantType , @Param("code") String code);
}
