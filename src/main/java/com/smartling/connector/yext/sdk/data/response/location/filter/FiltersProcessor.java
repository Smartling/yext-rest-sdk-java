package com.smartling.connector.yext.sdk.data.response.location.filter;

import com.smartling.connector.yext.sdk.data.response.location.Filters;

import java.util.stream.Collectors;

public class FiltersProcessor
{
    private static final String JSON_FORMAT = "{\"%s\": {\"%s\":%s}}";

    public String toJsonString(Filters filters)
    {
        String json = "{\"$and\":[%s]}";

        String filtersJsons = filters.getFilters().stream()
                .map(this::filterToJson)
                .collect(Collectors.joining(","));

        return String.format(json, filtersJsons);
    }

    private String filterToJson(Filters.Filter filter)
    {
        String conditions = filter.getValues().stream()
                .map(v -> String.format(JSON_FORMAT, filter.getField(), filter.getMatcher().getValue(), valueToString(v)))
                .collect(Collectors.joining(","));

        return String.format("{\"$or\":[%s]}", conditions);
    }

    private String valueToString(Object value)
    {
        if (value instanceof Boolean)
        {
            return Boolean.toString((Boolean) value);
        }
        else
        {
            return "\"" + value + "\"";
        }
    }
}
