package com.smartling.connector.yext.sdk.data.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class WebHookMeta
{

    @NotNull
    private WebHookEventType eventType;

    private String uuid;

    private String timestamp;

    private String accountId;

    private String actor;

    @NotBlank
    private String appSpecificAccountId;

    public WebHookEventType getEventType()
    {
        return eventType;
    }

    public void setEventType(WebHookEventType eventType)
    {
        this.eventType = eventType;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }

    public String getActor()
    {
        return actor;
    }

    public void setActor(String actor)
    {
        this.actor = actor;
    }

    public String getAppSpecificAccountId()
    {
        return appSpecificAccountId;
    }

    public void setAppSpecificAccountId(String appSpecificAccountId)
    {
        this.appSpecificAccountId = appSpecificAccountId;
    }

}
