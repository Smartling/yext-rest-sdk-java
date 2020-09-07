package com.smartling.connector.yext.sdk.data.response.location;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image
{
    private String clickthroughUrl;
    private String description;
    private String details;
    private Photo image;
}
