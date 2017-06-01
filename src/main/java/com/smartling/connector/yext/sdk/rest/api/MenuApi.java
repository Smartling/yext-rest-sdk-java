package com.smartling.connector.yext.sdk.rest.api;

import com.smartling.connector.yext.sdk.data.response.EmptyResponse;
import com.smartling.connector.yext.sdk.data.response.IdResponse;
import com.smartling.connector.yext.sdk.data.response.menu.Menu;
import com.smartling.connector.yext.sdk.data.response.menu.MenuResponse;
import com.smartling.connector.yext.sdk.data.response.menu.MenusResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.ACCEPT_APPLICATION_JSON;
import static com.smartling.connector.yext.sdk.utils.RestApiUtils.CONTENT_TYPE_APPLICATION_JSON;

@Headers(ACCEPT_APPLICATION_JSON)
public interface MenuApi {

    @RequestLine("GET /accounts/me/menus?access_token={access_token}&v={v}&limit={limit}&offset={offset}")
    MenusResponse listMenu(@Param("access_token") String accessToken, @Param("v") String v,
                           @Param("offset") Integer offset, @Param("limit") Integer limit);

    @RequestLine("GET /accounts/me/menus/{menuId}?access_token={access_token}&v={v}")
    MenuResponse getMenuById(@Param("access_token") String accessToken, @Param("v") String v, @Param("menuId") String menuId);

    @Headers(CONTENT_TYPE_APPLICATION_JSON)
    @RequestLine("POST accounts/me/menus?access_token={access_token}&v={v}")
    IdResponse createMenu(@Param("access_token") String accessToken, @Param("v") String v, Menu menu);

    @Headers(CONTENT_TYPE_APPLICATION_JSON)
    @RequestLine("PUT accounts/me/menus/{menuId}?access_token={access_token}&v={v}")
    MenuResponse updateMenu(@Param("access_token") String accessToken, @Param("v") String v, @Param("menuId") String menuId, Menu menu);

    @RequestLine("DELETE /accounts/me/menus/{menuId}?access_token={access_token}&v={v}")
    EmptyResponse deleteMenuById(@Param("access_token") String accessToken, @Param("v") String v, @Param("menuId") String menuId);

}
