package com.smartling.connector.yext.sdk.data.response.location.filter;

import com.smartling.connector.yext.sdk.data.response.location.Filters;

import java.util.stream.Collectors;

public class MultiValueFilterProcessor implements FilterProcessor
{
    @Override
    public String toJsonString(Filters.Filter filter)
    {
        String values = "[" +
                filter.getValues().stream()
                        .map(FilterProcessor::valueToString)
                        .collect(Collectors.joining(",")) +
                "]";

        return String.format(JSON_FORMAT, filter.getField(), filter.getMatcher().getValue(), values);
    }
}
