package com.smartling.connector.yext.sdk.data.response;

import com.smartling.connector.yext.sdk.data.Location;

import java.util.List;

public class ListLocations
{
    private Integer count;
    private List<Location> locations;

    public Integer getCount()
    {
        return count;
    }

    public void setCount(final Integer count)
    {
        this.count = count;
    }

    public List<Location> getLocations()
    {
        return locations;
    }

    public void setLocations(final List<Location> locations)
    {
        this.locations = locations;
    }
}
