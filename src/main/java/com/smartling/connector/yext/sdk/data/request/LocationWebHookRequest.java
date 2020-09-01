package com.smartling.connector.yext.sdk.data.request;

import com.smartling.connector.yext.sdk.data.response.location.Location;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class LocationWebHookRequest
{
    @Valid
    @NotNull
    private WebHookMeta meta;

    @Valid
    @NotNull
    private Location location;

    public WebHookMeta getMeta()
    {
        return meta;
    }

    public void setMeta(WebHookMeta meta)
    {
        this.meta = meta;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

}
