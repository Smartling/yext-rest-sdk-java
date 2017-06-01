package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.Location;
import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import com.smartling.connector.yext.sdk.rest.api.LocationApi;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.generateV;

public class LocationClient extends ApiClient {
    private LocationApi locationApi;

    public LocationClient(final TimeoutConfiguration timeoutConfiguration, String accessToken) {
        super(timeoutConfiguration, accessToken);
        locationApi = buildApiWithOAuthAuthentication(LocationApi.class, BASE_API_URL);
    }

    public LocationsResponse searchLocations(int offset, int limit, String search) {
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, buildNameFilter(search));
    }

    public LocationsResponse searchLocationsByMenuId(int offset, int limit, String menuId) {
        String searchFilter = String.format("[{\"menuIds\":{\"includes\": [\"%s\"]}}]", menuId);
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, searchFilter);
    }

    public LocationResponse getLocationById(String locationId) {
        return locationApi.getLocation(locationId, accessToken, generateV());
    }

    public LocationProfilesResponse listLocationProfile(String locationId) {
        return locationApi.listLocationProfiles(locationId, accessToken, generateV());
    }

    public LocationResponse getLocationProfile(String locationId, String languageCode) {
        return locationApi.getLocationProfile(locationId, accessToken, generateV(), languageCode);
    }

    public void upsertLocationLanguageProfile(String locationId, String languageCode, Location location) {
        location.setMenuIds(null);
        locationApi.upsertLanguageProfile(locationId, languageCode, generateV(), accessToken, location);
    }

    public void updateLocationProfileForMenu(Location locationProfile, String menuId, String languageCode) {
        locationProfile.assureMenus().getMenuIds().add(menuId);
        locationApi.upsertLanguageProfile(
                locationProfile.getId(), languageCode, generateV(), accessToken, locationProfile
        );
    }

    public void updateLocation(String locationId, Location location) {
        locationApi.updateLocation(locationId, generateV(), accessToken, location);
    }

    private String buildNameFilter(String name) {
        return String.format("[{\"name\": {\"contains\": [\"%s\"]}}]", name);
    }
}
