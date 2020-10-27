package com.smartling.connector.yext.sdk.data.request.sort;

public class Sort
{
    private String fieldName;
    private Order order;

    public Sort()
    {

    }

    public Sort(String fieldName, Order order)
    {
        this.fieldName = fieldName;
        this.order = order;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    public enum Order
    {
        ASCENDING, DESCENDING
    }
}
