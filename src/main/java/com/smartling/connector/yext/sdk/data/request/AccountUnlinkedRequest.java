package com.smartling.connector.yext.sdk.data.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AccountUnlinkedRequest
{

    @Valid
    @NotNull
    private WebHookMeta meta;

    public WebHookMeta getMeta()
    {
        return meta;
    }

    public void setMeta(WebHookMeta meta)
    {
        this.meta = meta;
    }

}
