package com.smartling.connector.yext.sdk.data.response.product;

import java.util.List;

public class ProductSection
{
    private String description;

    private String id;

    private String name;

    private List<ProductItem> items;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<ProductItem> getItems()
    {
        return items;
    }

    public void setItems(List<ProductItem> items)
    {
        this.items = items;
    }

}

