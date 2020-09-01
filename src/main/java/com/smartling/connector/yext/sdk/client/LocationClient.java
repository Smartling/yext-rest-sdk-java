package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.response.location.EntityLink;
import com.smartling.connector.yext.sdk.data.response.location.Location;
import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import com.smartling.connector.yext.sdk.rest.api.LocationApi;

import java.util.ArrayList;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.generateV;

public class LocationClient extends ApiClient
{
    private LocationApi locationApi;

    public LocationClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        super(timeoutConfiguration, accessToken);
        locationApi = buildApiWithOAuthAuthentication(LocationApi.class, BASE_API_URL);
    }

    public LocationsResponse searchLocations(int offset, int limit, String search)
    {
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, buildNameFilter(search));
    }

    public LocationsResponse searchLocationsByMenuId(int offset, int limit, String menuId)
    {
        String searchFilter = String.format("{\"menus.ids\":{\"$in\":[\"%s\"]}}", menuId);
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, searchFilter);
    }

    public LocationsResponse searchLocationsByProductId(int offset, int limit, String productId)
    {
        String searchFilter = String.format("{\"productLists.ids\":{\"$in\":[\"%s\"]}}", productId);
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, searchFilter);
    }

    public LocationResponse getLocationById(String locationId)
    {
        return locationApi.getLocation(locationId, accessToken, generateV());
    }

    public LocationProfilesResponse listLocationProfile(String locationId)
    {
        return locationApi.listLanguageProfiles(locationId, accessToken, generateV());
    }

    public LocationResponse getLocationProfile(String locationId, String languageCode)
    {
        return locationApi.getLanguageProfile(locationId, accessToken, generateV(), languageCode);
    }

    public void upsertLocationLanguageProfile(String locationId, String languageCode, Location location)
    {
        location.setMenus(null);
        location.setProductLists(null);
        // TODO only for a none primary language profile
        location.setPaymentOptions(null);
        location.setClosed(null);
        locationApi.upsertLanguageProfile(locationId, languageCode, generateV(), accessToken, location);
    }

    public void updateLocationProfileForMenu(Location locationProfile, String menuId, String languageCode)
    {
        if (locationProfile.getMenus() == null)
        {
            locationProfile.setMenus(new EntityLink());
        }
        if (locationProfile.getMenus().getIds() == null)
        {
            locationProfile.getMenus().setIds(new ArrayList<>());
        }
        locationProfile.getMenus().getIds().add(menuId);
        locationApi.upsertLanguageProfile(
                locationProfile.getMeta().getId(), languageCode, generateV(), accessToken, locationProfile
        );
    }

    public void updateLocationProfileForProduct(Location locationProfile, String productId, String languageCode)
    {
        if (locationProfile.getProductLists() == null)
        {
            locationProfile.setProductLists(new EntityLink());
        }
        if (locationProfile.getProductLists().getIds() == null)
        {
            locationProfile.getProductLists().setIds(new ArrayList<>());
        }
        locationProfile.getProductLists().getIds().add(productId);
        locationApi.upsertLanguageProfile(
                locationProfile.getMeta().getId(), languageCode, generateV(), accessToken, locationProfile
        );
    }

    private String buildNameFilter(String name)
    {
        return String.format("{\"name\": {\"$contains\": \"%s\"}}", name);
    }
}
