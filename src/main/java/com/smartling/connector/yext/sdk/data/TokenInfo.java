package com.smartling.connector.yext.sdk.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenInfo
{
    @JsonProperty ("access_token")
    private String accessToken;
    private String accountName;
    private String appSpecificAccountId;

    public String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(final String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public void setAccountName(final String accountName)
    {
        this.accountName = accountName;
    }

    public String getAppSpecificAccountId()
    {
        return appSpecificAccountId;
    }

    public void setAppSpecificAccountId(final String appSpecificAccountId)
    {
        this.appSpecificAccountId = appSpecificAccountId;
    }
}
