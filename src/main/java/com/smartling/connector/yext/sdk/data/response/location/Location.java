package com.smartling.connector.yext.sdk.data.response.location;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Location
{
    private Meta meta;

    private String name;
    private Address address;
    private String additionalHoursText;
    private List<String> associations;
    private List<String> brands;
    private String description;
    private FeaturedMessage featuredMessage;
    private List<String> languages;
    private Image logo;
    private List<Image> photoGallery;
    private EntityLink productLists;
    private Url reservationUrl;
    private List<String> services;
    private List<String> keywords;
    private List<String> products;
    private List<String> specialities;
    private EntityLink menus;

    @JsonIgnore
    private Map<String, Object> customFields = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getCustomFields() {
        return customFields;
    }

    @JsonAnySetter
    public void addCustomField(String propertyName, Object value)
    {
        if (propertyName.startsWith("c_"))
        {
            customFields.put(propertyName, value);
        }
    }
}
