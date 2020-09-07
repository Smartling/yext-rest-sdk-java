package com.smartling.connector.yext.sdk.data.response;

import com.smartling.connector.yext.sdk.data.response.location.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListLocations
{
    private Integer count;
    private List<Location> entities;
}
