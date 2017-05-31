package com.smartling.connector.yext.sdk.data.response.menu;

import java.util.List;

public class ListMenus {

    private Integer count;

    private List<Menu> menus;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}

