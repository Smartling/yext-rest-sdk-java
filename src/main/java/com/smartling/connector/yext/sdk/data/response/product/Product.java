package com.smartling.connector.yext.sdk.data.response.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Product
{
    private String name;

    private String language;

    private String title;

    private Boolean publish;

    private String accountId;

    private String id;

    private Integer size;

    private String currency;

    private List<ProductSection> sections;
}

