package com.smartling.connector.yext.sdk.rest.api;

import com.smartling.connector.yext.sdk.data.response.menu.MenusResponse;
import feign.Param;
import feign.RequestLine;

public interface MenuApi
{

    @RequestLine("GET /accounts/me/menus?access_token={access_token}&v={v}&limit={limit}&offset={offset}")
    MenusResponse listMenu(@Param("access_token") String accessToken, @Param("v") String v,
                           @Param("offset") Integer offset, @Param("limit") Integer limit);

}
