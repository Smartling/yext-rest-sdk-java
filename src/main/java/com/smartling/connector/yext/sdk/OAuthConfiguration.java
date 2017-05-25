package com.smartling.connector.yext.sdk;

import org.apache.commons.lang3.Validate;

public class OAuthConfiguration extends TimeoutConfiguration
{
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;

    public OAuthConfiguration(final String clientId, final String clientSecret, final String redirectUri)
    {
        this.redirectUri = Validate.notEmpty(redirectUri, "RedirectUri can not be empty");;
        this.clientId = Validate.notEmpty(clientId, "ClientId can not be empty");
        this.clientSecret = Validate.notEmpty(clientSecret, "ClientSecret can not be empty");
    }

    public String getClientId()
    {
        return clientId;
    }

    public String getClientSecret()
    {
        return clientSecret;
    }

    public String getRedirectUri()
    {
        return redirectUri;
    }
}
