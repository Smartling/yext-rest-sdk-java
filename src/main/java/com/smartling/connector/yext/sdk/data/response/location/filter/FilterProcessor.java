package com.smartling.connector.yext.sdk.data.response.location.filter;

import com.smartling.connector.yext.sdk.data.response.location.Filters;

public interface FilterProcessor
{
    String JSON_FORMAT = "{\"%s\": {\"%s\":%s}}";

    String toJsonString(Filters.Filter filter);

    static String valueToString(Object value)
    {
        if (value instanceof Number)
        {
            return String.valueOf(value);
        }
        else
        {
            return "\"" + value + "\"";
        }
    }
}
