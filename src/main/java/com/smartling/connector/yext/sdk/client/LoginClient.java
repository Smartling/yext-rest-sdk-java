package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.OAuthConfiguration;
import com.smartling.connector.yext.sdk.data.TokenInfo;
import com.smartling.connector.yext.sdk.rest.api.LoginApi;

import static com.smartling.connector.yext.sdk.client.ApiClient.buildApi;

public class LoginClient
{
    private final LoginApi loginApi;
    private final OAuthConfiguration OAuthConfiguration;
    private final String code;

    public LoginClient(final OAuthConfiguration OAuthConfiguration, final String code)
    {
        this.code = code;
        this.OAuthConfiguration = OAuthConfiguration;
        this.loginApi = buildApi(LoginApi.class, ApiClient.BASE_AUTH_API_URL, OAuthConfiguration);
    }

    public TokenInfo getTokenInfo()
    {
        return loginApi.getTokenInfo(OAuthConfiguration.getClientId(), OAuthConfiguration.getClientSecret(), OAuthConfiguration.getRedirectUri(), "authorization_code" , code);
    }
}
