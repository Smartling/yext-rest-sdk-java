package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.LocationClient;
import com.smartling.connector.yext.sdk.client.MenuClient;
import com.smartling.connector.yext.sdk.data.Location;
import com.smartling.connector.yext.sdk.data.response.IdResponse;
import com.smartling.connector.yext.sdk.data.response.menu.ListMenus;
import com.smartling.connector.yext.sdk.data.response.menu.Menu;
import com.smartling.connector.yext.sdk.data.response.menu.MenuResponse;
import com.smartling.connector.yext.sdk.data.response.menu.MenusResponse;
import com.smartling.connector.yext.sdk.rest.YextRestException;
import com.smartling.connector.yext.sdk.utils.JsonUtils;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.smartling.connector.yext.sdk.utils.CollectionUtils.first;
import static com.smartling.connector.yext.sdk.utils.CollectionUtils.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuIntegrationTest extends BaseIntegrationTest
{

    @Test
    public void createMenu()
    {
        MenuClient client = menuClient();
        Menu menu = createMenu(client);
        client.deleteMenuById(menu.getId());
    }

    @Test
    public void updateMenu()
    {
        MenuClient client = menuClient();

        Menu expectedMenu = createMenu(client);
        String menuId = expectedMenu.getId();
        expectedMenu.setName("updated " + expectedMenu.getName());
        expectedMenu.setTitle("updated " + expectedMenu.getTitle());

        client.updateMenu(menuId, expectedMenu);

        Menu actualMenu = getMenuById(client, menuId);
        assertFields(actualMenu, expectedMenu);

        client.deleteMenuById(expectedMenu.getId());
    }

    @Test
    public void getMenuById()
    {
        MenuClient client = menuClient();

        Menu expected = createMenu(client);

        Menu actual = getMenuById(client, expected.getId());
        assertThat(actual.getId()).isNotNull();
        assertFields(actual, expected);

        client.deleteMenuById(expected.getId());
    }

    @Test
    public void listMenu()
    {
        getMenusList(menuClient());
    }

    @Test
    public void deleteMenuById()
    {
        MenuClient client = menuClient();

        Menu menu = createMenu(client);
        client.deleteMenuById(menu.getId());

        assertThatThrownBy(() -> client.deleteMenuById(menu.getId()))
                .isInstanceOf(YextRestException.class)
                .hasMessageContaining("404");
    }

    @Test
    public void cloneMenuForLanguage() throws InterruptedException
    {
        MenuClient client = menuClient();
        LocationClient locationClient = locationClient();

        Menu srcMenu = createMenu(client);
        String srcMenuId = srcMenu.getId();
        generateFields(srcMenu);

        Location yextMainLocation = getYextMainLocation(locationClient);

        // update default English profile for English menu
        locationClient.updateLocationProfileForMenu(yextMainLocation, srcMenu.getId(), srcMenu.getLanguage());

        // to search locations
        TimeUnit.SECONDS.sleep(1);
        final int offset = 0;
        final int limit = 50;
        List<Location> srcLocations = locationClient.searchLocationsByMenuId(offset, limit, srcMenu.getId())
                .getResponse().getLocations();

        assertThat(srcLocations).hasSize(1);
        assertThat(first(srcLocations).getId()).isEqualTo(yextMainLocation.getId());

        srcMenu.setId(null);
        String langCode = changeLang(srcMenu.getLanguage());
        srcMenu.setLanguage(langCode);

        String clonedId = client.createMenu(srcMenu).getIdAsString();

        stream(srcLocations).forEach(enLocation ->
        {
            Location langProfile = locationClient.getLocationProfile(
                    enLocation.getId(), langCode
            ).getResponse();
            locationClient.updateLocationProfileForMenu(langProfile, clonedId, langCode);
        });

        Location withClonedMenu = locationClient
                .getLocationProfile(yextMainLocation.getId(), langCode).getResponse();


        assertThat(withClonedMenu.getMenuIds()).contains(clonedId);

        client.deleteMenuById(srcMenuId);
        client.deleteMenuById(clonedId);
    }

    // to check API
    //@Test
    public void cloneExistingMenuForLanguage() throws InterruptedException
    {
        MenuClient client = menuClient();
        LocationClient locationClient = locationClient();

        final String srcMenuId = "511207";
        //final String srcMenuId = "511498";
        //final String srcMenuId = "511713";

        final String langCode = "es";

        Menu srcMenu = client.getMenuById(srcMenuId).getResponse();
        srcMenu.setId(null);
        setNameAndTitle(srcMenu, srcMenu.getTitle() + " " + generateName() + " " + langCode);
        srcMenu.setLanguage(langCode);

        String clonedId = client.createMenu(srcMenu).getIdAsString();

        final int offset = 0;
        final int limit = 50;
        List<Location> srcLocations = locationClient.searchLocationsByMenuId(offset, limit, srcMenuId)
                .getResponse().getLocations();

        stream(srcLocations).forEach(enLocation ->
        {
            Location langProfile = locationClient.getLocationProfile(
                    enLocation.getId(), langCode
            ).getResponse();

            locationClient.updateLocationProfileForMenu(langProfile, clonedId, langCode);
        });
    }

    // to check API
    //@Test
    public void getExistingLocationById() throws InterruptedException
    {
        LocationClient client = locationClient();

        final String locationId = "1673810817640687022";
        final String langCode = "es";

        Location location = client.getLocationProfile(locationId, langCode).getResponse();

        System.out.println(JsonUtils.toJsonString(location));
    }

    // to check API
    //@Test
    public void getExistingMenuById() throws InterruptedException
    {
        MenuClient client = menuClient();

        final String menuId = "511207";

        Menu menu = client.getMenuById(menuId).getResponse();

        System.out.println(JsonUtils.toJsonString(menu));
    }

    private static String changeLang(String prevLang)
    {
        return prevLang.equals("en") ? "es" : "en";
    }

    private static Menu getMenuById(MenuClient client, String id)
    {
        assertThat(id).isNotEmpty();
        MenuResponse menuResponse = client.getMenuById(id);
        assertThat(menuResponse).isNotNull();

        Menu result = menuResponse.getResponse();
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        return result;
    }

    private static Menu createMenu(MenuClient client)
    {
        Menu newMenu = newMenu();
        generateFields(newMenu);

        IdResponse idResponse = client.createMenu(newMenu);
        assertThat(idResponse).isNotNull();

        Menu createdMenu = getMenuById(client, idResponse.getIdAsString());
        assertFields(createdMenu, newMenu);

        return createdMenu;
    }

    private static ListMenus getMenusList(MenuClient client)
    {
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

    private static void assertFields(Menu actual, Menu expected)
    {
        assertThat(expected).isNotNull();
        assertThat(actual).isNotNull();
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
    }

    private static void generateFields(Menu menu)
    {
        final String name = generateName();
        setNameAndTitle(menu, name);
    }

    private static void setNameAndTitle(Menu menu, String name)
    {
        menu.setName(name);
        menu.setTitle(name);
    }

    private static String generateName()
    {
        return "test " + System.currentTimeMillis();
    }

    private static Menu newMenu()
    {
        return JsonUtils.fromJsonByClassLoader("json/create_menu.json", Menu.class);
    }

}
