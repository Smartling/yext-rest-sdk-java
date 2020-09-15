package com.smartling.connector.yext.sdk.data.response.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class Filters
{
    private List<Filter> filters;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Filter
    {
        private String field;
        private List<Object> values;
        private Matcher matcher;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Matcher
    {
        CONTAINS("$contains"),
        EQ("$eq");

        private final String value;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Condition
    {
        AND("$and"),
        OR("$or");

        private final String value;
    }
}
