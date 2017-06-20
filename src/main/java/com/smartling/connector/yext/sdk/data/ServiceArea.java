package com.smartling.connector.yext.sdk.data;

import java.util.List;

public class ServiceArea
{

    private Integer radius;

    private String unit;

    private List<String> places;


    public Integer getRadius()
    {
        return radius;
    }

    public void setRadius(Integer radius)
    {
        this.radius = radius;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public List<String> getPlaces()
    {
        return places;
    }

    public void setPlaces(List<String> places)
    {
        this.places = places;
    }

}
