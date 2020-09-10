package com.smartling.connector.yext.sdk.data.response.location.filter;

import com.smartling.connector.yext.sdk.data.response.location.Filters;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FiltersProcessor
{
    private static final Map<Filters.Matcher,FilterProcessor> MATCHER_PROCESSOR  = new EnumMap<>(Filters.Matcher.class);

    static
    {
        MATCHER_PROCESSOR.put(Filters.Matcher.CONTAINS, new SingleValueFilterProcessor());
        MATCHER_PROCESSOR.put(Filters.Matcher.EQ, new SingleValueFilterProcessor());
        MATCHER_PROCESSOR.put(Filters.Matcher.CONTAINS_ANY, new MultiValueFilterProcessor());
        MATCHER_PROCESSOR.put(Filters.Matcher.IN, new MultiValueFilterProcessor());
    }

    public String toJsonString(Filters filters)
    {
        String json = "{\"$and\":[%s]}";

        String filtersJsons = filters.getFilters().stream()
                .map(f -> MATCHER_PROCESSOR.get(f.getMatcher()).toJsonString(f))
                .collect(Collectors.joining(","));

        return String.format(json, filtersJsons);
    }
}
