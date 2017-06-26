package com.smartling.connector.yext.sdk.data.response.customfields;


import java.util.List;

public class ListCustomFields
{
    private Integer count;

    private List<CustomField> customFields;

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public List<CustomField> getCustomFields()
    {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields)
    {
        this.customFields = customFields;
    }

}

