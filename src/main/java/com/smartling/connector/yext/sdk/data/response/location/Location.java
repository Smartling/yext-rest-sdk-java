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
    private boolean addressHidden;
    private String alternatePhone;
    private List<String> associations;
    private EntityLink bios;
    private List<String> brands;
    private Boolean closed;
    private String description;
    private List<String> emails;
    private String facebookPageUrl;
    private String fax;
    private FeaturedMessage featuredMessage;
    private String geomodifier;
    private Boolean holidayHoursConversationEnabled;
    private Object hours;
    private String instagramHandle;
    private String isoRegionCode;
    private String landingPageUrl;
    private List<String> languages;
    private Image logo;
    private Url menuUrl;
    private String mobilePhone;
    private Url orderUrl;
    private List<String> paymentOptions;
    private List<Image> photoGallery;

    private EntityLink productLists;
    private Url reservationUrl;

    private List<String> services;
    private String tollFreePhone;
    private String ttyPhone;
    private String twitterHandle;
    private List<Videos> videos;
    private Url websiteUrl;
    private Integer yearEstablished;
    private String androidAppUrl;
    private EntityLink calendars;
    private List<String> keywords;
    private String iosAppUrl;
    private EntityLink menus;
    private List<String> products;
    private List<String> specialities;

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
