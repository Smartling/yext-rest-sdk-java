package com.smartling.connector.yext.sdk.data.response.menu;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListMenus {

    private Integer count;

    private List<Menu> menus;
}

