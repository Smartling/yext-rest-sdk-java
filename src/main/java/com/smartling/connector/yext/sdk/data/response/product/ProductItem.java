package com.smartling.connector.yext.sdk.data.response.product;

import com.smartling.connector.yext.sdk.data.ContentListCost;
import com.smartling.connector.yext.sdk.data.ContentListPhoto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductItem
{
    private String description;

    private String id;

    private String name;

    private String url;

    private List<ContentListPhoto> photos;

    private String idcode;

    private ContentListCost cost;

    private String video;
}

