package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.MenuClient;
import com.smartling.connector.yext.sdk.data.response.menu.ListMenus;
import com.smartling.connector.yext.sdk.data.response.menu.MenusResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuIntegrationTest extends BaseIntegrationTest
{

    @Test
    public void listMenu() {
        MenuClient menuClient = new MenuClient(timeoutConfiguration, accessToken);

        MenusResponse menusResponse = menuClient.listMenu(0, 50);
        assertThat(menusResponse).isNotNull();

        ListMenus menus = menusResponse.getResponse();
        assertThat(menus).isNotNull();
        assertThat(menus.getCount()).isGreaterThan(0);
        assertThat(menus.getMenus()).isNotEmpty();
    }

}
