package com.smartling.connector.yext.sdk.data.request.sort;

import java.util.List;
import java.util.stream.Collectors;

public class SortProcessor
{
    private static final String SORT_FIELD_FORMAT = "{\"%s\": \"%s\"}";

    public static String toJson(List<Sort> sortByList)
    {
        return "[" +
                sortByList.stream()
                    .map(f -> String.format(SORT_FIELD_FORMAT, f.getFieldName(), f.getOrder().toString()))
                    .collect(Collectors.joining(","))
                + "]";
    }
}
