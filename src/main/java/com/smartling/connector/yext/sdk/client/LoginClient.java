package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.Configuration;
import com.smartling.connector.yext.sdk.data.TokenInfo;
import com.smartling.connector.yext.sdk.rest.api.LoginApi;

import static com.smartling.connector.yext.sdk.client.ApiClient.buildApi;

public class LoginClient
{
    private final LoginApi loginApi;
    private final Configuration configuration;
    private final String code;

    public LoginClient(final Configuration configuration, final String code)
    {
        this.code = code;
        this.configuration = configuration;
        this.loginApi = buildApi(LoginApi.class, ApiClient.BASE_AUTH_API_URL, configuration);
    }

    public TokenInfo getTokenInfo()
    {
        return loginApi.getTokenInfo(configuration.getClientId(), configuration.getClientSecret(), configuration.getRedirectUri(), "authorization_code" , code);
    }
}