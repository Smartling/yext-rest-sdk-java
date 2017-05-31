package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.response.menu.MenusResponse;
import com.smartling.connector.yext.sdk.rest.api.MenuApi;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.generateV;

public class MenuClient extends ApiClient
{
    private MenuApi menuApi;

    public MenuClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        super(timeoutConfiguration, accessToken);
        menuApi = buildApiWithOAuthAuthentication(MenuApi.class, BASE_API_URL);
    }

    public MenusResponse listMenu(int offset, int limit)
    {
        return menuApi.listMenu(accessToken, generateV(), offset, limit);
    }

}
