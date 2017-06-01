package com.smartling.connector.yext.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartling.connector.yext.sdk.client.MenuClient;
import com.smartling.connector.yext.sdk.data.response.IdResponse;
import com.smartling.connector.yext.sdk.data.response.menu.ListMenus;
import com.smartling.connector.yext.sdk.data.response.menu.Menu;
import com.smartling.connector.yext.sdk.data.response.menu.MenuResponse;
import com.smartling.connector.yext.sdk.data.response.menu.MenusResponse;
import com.smartling.connector.yext.sdk.utils.JsonUtils;
import org.junit.Test;

import static com.smartling.connector.yext.sdk.utils.CollectionUtils.first;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuIntegrationTest extends BaseIntegrationTest {

    @Test
    public void createMenu() {
        createMenu(menuClient());
    }

    @Test
    public void updateMenu() {
        MenuClient client = menuClient();

        Menu expectedMenu = getOrCreateMenu(client);

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

        Menu expected = getOrCreateMenu(client);
        Menu actual = getMenuById(client, expected.getId());
        assertThat(actual.getId()).isNotNull();
        assertFields(actual, expected);

        // TODO
        //System.out.println(toJsonString(actual));
    }

    @Test
    public void listMenu() {
        getMenusList(menuClient());
    }

    @Test
    public void cloneMenuForLanguage() {
        MenuClient client = menuClient();
        String menuId = getOrCreateMenu(client).getId();

        Menu srcMenu = getMenuById(client, menuId);
        srcMenu.setId(null);
        setNameAndTitle(srcMenu, srcMenu.getTitle() + " cloned for the lang");
        srcMenu.setLanguage(changeLang(srcMenu.getLanguage()));

        IdResponse idResponse = client.createMenu(srcMenu);
        Menu destMenu = getMenuById(client, idResponse.getIdAsString());
        assertFields(destMenu, srcMenu);
        assertThat(destMenu.getLanguage()).isEqualTo(srcMenu.getLanguage());

        // TODO
        //System.out.println(toJsonString(srcMenu));
        //System.out.println(toJsonString(destMenu));
    }

    private static String changeLang(String prevLang) {
        return prevLang.equals("en") ? "es" : "en";
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

    private static Menu getOrCreateMenu(MenuClient client) {
        Menu result = first(getMenusList(client).getMenus());
        return result == null ? createMenu(client) : result;
    }

    private static Menu createMenu(MenuClient client) {
        Menu newMenu = newMenu();
        generateFields(newMenu);

        IdResponse idResponse = client.createMenu(newMenu);
        assertThat(idResponse).isNotNull();

        Menu createdMenu = getMenuById(client, idResponse.getIdAsString());
        assertFields(createdMenu, newMenu);

        return createdMenu;
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
        setNameAndTitle(menu, name);
    }

    private static void setNameAndTitle(Menu menu, String name) {
        menu.setName(name);
        menu.setTitle(name);
    }

    private static String generateName() {
        return "test " + System.currentTimeMillis();
    }

    private static Menu newMenu() {
        return JsonUtils.fromJsonByClassLoader("json/create_menu.json", Menu.class);
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
