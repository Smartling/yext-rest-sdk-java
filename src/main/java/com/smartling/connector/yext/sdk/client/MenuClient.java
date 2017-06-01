package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.response.IdResponse;
import com.smartling.connector.yext.sdk.data.response.menu.Menu;
import com.smartling.connector.yext.sdk.data.response.menu.MenuResponse;
import com.smartling.connector.yext.sdk.data.response.menu.MenusResponse;
import com.smartling.connector.yext.sdk.rest.api.MenuApi;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.generateV;

public class MenuClient extends ApiClient {
    private MenuApi menuApi;

    public MenuClient(final TimeoutConfiguration timeoutConfiguration, String accessToken) {
        super(timeoutConfiguration, accessToken);
        menuApi = buildApiWithOAuthAuthentication(MenuApi.class, BASE_API_URL);
    }

    public IdResponse createMenu(Menu menu) {
        return menuApi.createMenu(accessToken, generateV(), menu);
    }

    public void updateMenu(String menuId, Menu menu) {
        menuApi.updateMenu(accessToken, generateV(), menuId, menu);
    }

    public MenuResponse getMenuById(String menuId) {
        return menuApi.getMenuById(accessToken, generateV(), menuId);
    }

    public MenusResponse listMenu(int offset, int limit) {
        return menuApi.listMenu(accessToken, generateV(), offset, limit);
    }

    /**
     * This method throws an exception for HTTP errors.
     */
    public void deleteMenuById(String menuId) {
        menuApi.deleteMenuById(accessToken, generateV(), menuId);
    }

}
