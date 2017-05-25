package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.Location;
import com.smartling.connector.yext.sdk.data.response.LocationProfilesResponse;
import com.smartling.connector.yext.sdk.data.response.LocationResponse;
import com.smartling.connector.yext.sdk.data.response.LocationsResponse;
import com.smartling.connector.yext.sdk.rest.api.LocationApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LocationClient extends ApiClient
{
    private LocationApi locationApi;

    public LocationClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        super(timeoutConfiguration, accessToken);
        locationApi = buildApiWithOAuthAuthentication(LocationApi.class, BASE_API_URL);
    }

    public LocationsResponse searchLocations(int limit, int offset, String search)
    {
        return locationApi.searchLocations(accessToken, generateV(), limit, offset, buildNameFilter(search));
    }

    public LocationResponse getLocationById(String locationId)
    {
        return locationApi.getLocation(locationId, accessToken, generateV());
    }

    public LocationProfilesResponse listLocationProfile(String locationId)
    {
        return locationApi.listLocationProfiles(locationId, accessToken, generateV());
    }

    public LocationResponse getLocationProfile(String locationId, String languageCode)
    {
        return locationApi.getLocationProfile(locationId, accessToken, generateV(), languageCode);
    }

    public void upsertLocationLanguageProfile(String locationId, String languageCode, Location location)
    {
        locationApi.upsertLanguageProfile(locationId, languageCode, generateV(), accessToken, location);
    }

    private String generateV()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
        return format.format(cal.getTime());
    }

    private String buildNameFilter(String name)
    {
        return String.format("[{\"name\": {\"contains\": [\"%s\"]}}]", name);
    }
}
