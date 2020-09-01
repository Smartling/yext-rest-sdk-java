package com.smartling.connector.yext.sdk.data.response.menu;

import com.smartling.connector.yext.sdk.data.ContentListCost;
import com.smartling.connector.yext.sdk.data.ContentListPhoto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuItem
{
    private String description;

    private String id;

    private String name;

    private ContentListPhoto photo;

    private ContentListCost cost;

    private Calories calories;
}

