package com.smartling.connector.yext.sdk.data.response.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address
{
    private String line1;
    private String line2;
    private String line3;
    private String city;
    private String region;
    private String postalCode;
    private String countryCode;
    private String extraDescription;
    private String sublocality;
}
