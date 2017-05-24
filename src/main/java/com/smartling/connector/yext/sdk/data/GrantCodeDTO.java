package com.smartling.connector.yext.sdk.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrantCodeDTO
{
    @JsonProperty ("grant_type")
    private final String grantType = "authorization_code";
    private final String code;
    @JsonProperty ("redirect_uri")
    private final String redirectUri;
    @JsonProperty ("client_id")
    private final String clientId;
    @JsonProperty ("client_secret")
    private final String clientSecret;

    public GrantCodeDTO(final String code, final String redirectUri, final String clientId, final String clientSecret)
    {
        this.code = code;
        this.redirectUri = redirectUri;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getGrantType()
    {
        return grantType;
    }

    public String getCode()
    {
        return code;
    }

    public String getRedirectUri()
    {
        return redirectUri;
    }

    public String getClientId()
    {
        return clientId;
    }

    public String getClientSecret()
    {
        return clientSecret;
    }
}
