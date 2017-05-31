package com.smartling.connector.yext.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartling.connector.yext.sdk.client.MenuClient;
import com.smartling.connector.yext.sdk.data.response.IdResponse;
import com.smartling.connector.yext.sdk.data.response.menu.ListMenus;
import com.smartling.connector.yext.sdk.data.response.menu.Menu;
import com.smartling.connector.yext.sdk.data.response.menu.MenuResponse;
import com.smartling.connector.yext.sdk.data.response.menu.MenusResponse;
import org.junit.Test;

import static com.smartling.connector.yext.sdk.utils.CollectionUtils.first;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuIntegrationTest extends BaseIntegrationTest {

    @Test
    public void createMenu() {
        MenuClient client = menuClient();

        Menu newMenu = getFirstMenu(client);
        newMenu.setId(null);
        generateFields(newMenu);

        IdResponse idResponse = client.createMenu(newMenu);
        assertThat(idResponse).isNotNull();

        Menu createdMenu = getMenuById(client, idResponse.getIdAsString());
        assertFields(createdMenu, newMenu);

        // TODO
        //System.out.println("newMenu " + toJsonString(newMenu));
        //System.out.println("createdMenu " + toJsonString(createdMenu));
    }

    @Test
    public void updateMenu() {
        MenuClient client = menuClient();

        Menu expectedMenu = getFirstMenu(client);

        String menuId = expectedMenu.getId();
        expectedMenu.setName("updated " + expectedMenu.getName());
        expectedMenu.setTitle("updated " + expectedMenu.getTitle());

        MenuResponse menuResponse = client.updateMenu(menuId, expectedMenu);
        assertThat(menuResponse).isNotNull();
        assertThat(menuResponse.getResponse()).isNotNull();
        // response contains id only
        assertThat(menuResponse.getResponse().getId()).isEqualTo(menuId);

        Menu actualMenu = getMenuById(client, menuId);
        assertFields(actualMenu, expectedMenu);

        // TODO
        //System.out.println("menuResponse " + toJsonString(menuResponse.getResponse()));
        //System.out.println("expectedMenu " + toJsonString(expectedMenu));
        //System.out.println("actualMenu " + toJsonString(actualMenu));
    }

    @Test
    public void getMenuById() {
        MenuClient client = menuClient();

        Menu expected = getFirstMenu(client);
        Menu actual = getMenuById(client, expected.getId());
        assertFields(actual, expected);

        // TODO
        //System.out.println(toJsonString(actual));
    }

    @Test
    public void listMenu() {
        ListMenus menus = getMenusList(menuClient());

        // TODO
        //System.out.println(toJsonString(menus));
    }

    private static Menu getMenuById(MenuClient client, String id) {
        assertThat(id).isNotEmpty();
        MenuResponse menuResponse = client.getMenuById(id);
        assertThat(menuResponse).isNotNull();

        Menu result = menuResponse.getResponse();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        return result;
    }

    private static Menu getFirstMenu(MenuClient client) {
        return first(getMenusList(client).getMenus());
    }

    private static ListMenus getMenusList(MenuClient client) {
        final int offset = 0;
        final int limit = 50;
        MenusResponse menusResponse = client.listMenu(offset, limit);
        assertThat(menusResponse).isNotNull();

        ListMenus result = menusResponse.getResponse();
        assertThat(result).isNotNull();
        assertThat(result.getCount()).isGreaterThan(0);
        assertThat(result.getMenus()).isNotEmpty();

        return result;
    }

    private static void assertFields(Menu actual, Menu expected) {
        assertThat(expected).isNotNull();
        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
    }

    private static void generateFields(Menu menu) {
        final String name = generateName();
        menu.setName(name);
        menu.setTitle(name);
    }

    private static String generateName() {
        return "test " + System.currentTimeMillis();
    }

    // TODO delete
    private static <T> String toJsonString(T object) {
        try {
            return object == null ? null : new ObjectMapper().writeValueAsString(object);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
