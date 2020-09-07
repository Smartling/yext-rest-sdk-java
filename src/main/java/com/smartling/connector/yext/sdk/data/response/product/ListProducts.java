package com.smartling.connector.yext.sdk.data.response.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListProducts
{
    private Integer count;

    private List<Product> products;
}

