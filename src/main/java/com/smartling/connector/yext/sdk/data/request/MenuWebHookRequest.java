package com.smartling.connector.yext.sdk.data.request;

import com.smartling.connector.yext.sdk.data.response.menu.Menu;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MenuWebHookRequest
{

    @Valid
    @NotNull
    private WebHookMeta meta;

    @Valid
    @NotNull
    private Menu menu;

    public WebHookMeta getMeta()
    {
        return meta;
    }

    public void setMeta(WebHookMeta meta)
    {
        this.meta = meta;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

}
