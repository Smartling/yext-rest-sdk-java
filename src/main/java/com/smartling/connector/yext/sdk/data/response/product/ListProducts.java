package com.smartling.connector.yext.sdk.data.response.product;

import java.util.List;

public class ListProducts
{

    private Integer count;

    private List<Product> products;

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

}

