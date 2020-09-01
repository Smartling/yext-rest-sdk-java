package com.smartling.connector.yext.sdk.data.response.menu;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MenuSection {

    private String description;

    private String id;

    private String name;

    private List<MenuItem> items;
}

