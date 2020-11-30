package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.request.sort.Sort;
import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import com.smartling.connector.yext.sdk.data.response.location.Filters;
import com.smartling.connector.yext.sdk.data.response.location.Location;
import com.smartling.connector.yext.sdk.data.response.location.filter.FiltersProcessor;
import com.smartling.connector.yext.sdk.rest.api.LocationApi;

import java.util.List;

import static com.smartling.connector.yext.sdk.data.request.sort.SortProcessor.toJson;
import static com.smartling.connector.yext.sdk.utils.RestApiUtils.generateV;
import static java.util.Collections.emptyList;

public class LocationClient extends ApiClient
{
    private LocationApi locationApi;
    private FiltersProcessor filtersProcessor;

    public LocationClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        super(timeoutConfiguration, accessToken);
        this.locationApi = buildApiWithOAuthAuthentication(LocationApi.class, BASE_API_URL);
        this.filtersProcessor = new FiltersProcessor();
    }

    public LocationsResponse searchLocations(int offset, int limit, Filters filters, List<Sort> sortBy)
    {
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, filtersProcessor.toJsonString(filters), toJson(sortBy));
    }

    public LocationsResponse searchLocationsByMenuId(int offset, int limit, String menuId)
    {
        String searchFilter = String.format("{\"menus.ids\":{\"$in\":[\"%s\"]}}", menuId);
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, searchFilter, toJson(emptyList()));
    }

    public LocationsResponse searchLocationsByProductId(int offset, int limit, String productId)
    {
        String searchFilter = String.format("{\"productLists.ids\":{\"$in\":[\"%s\"]}}", productId);
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, searchFilter, toJson(emptyList()));
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
        locationApi.upsertLanguageProfile(locationId, languageCode, generateV(), accessToken, location);
    }
}
