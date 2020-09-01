package com.smartling.connector.yext.sdk.data.response.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductSection
{
    private String description;

    private String id;

    private String name;

    private List<ProductItem> items;
}

