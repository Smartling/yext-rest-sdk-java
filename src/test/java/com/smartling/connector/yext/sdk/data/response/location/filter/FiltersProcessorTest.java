package com.smartling.connector.yext.sdk.data.response.location.filter;

import com.smartling.connector.yext.sdk.data.response.location.Filters;
import org.junit.Test;

import java.util.Arrays;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FiltersProcessorTest
{
    private FiltersProcessor target = new FiltersProcessor();

    @Test
    public void containsAnyFilter()
    {
        Filters filters = new Filters();
        filters.setFilters(singletonList(new Filters.Filter("name", Arrays.asList("v1", "v2"), Filters.Matcher.CONTAINS_ANY)));

        assertThat(target.toJsonString(filters), equalTo("{\"$and\":[{\"name\": {\"$containsAny\":[\"v1\",\"v2\"]}}]}"));
    }

    @Test
    public void inFilter()
    {
        Filters filters = new Filters();
        filters.setFilters(singletonList(new Filters.Filter("name", Arrays.asList("v1", "v2"), Filters.Matcher.IN)));

        assertThat(target.toJsonString(filters), equalTo("{\"$and\":[{\"name\": {\"$in\":[\"v1\",\"v2\"]}}]}"));
    }

    @Test
    public void eqFilter()
    {
        Filters filters = new Filters();
        filters.setFilters(singletonList(new Filters.Filter("name", Arrays.asList("v1", "v2"), Filters.Matcher.EQ)));

        assertThat(target.toJsonString(filters), equalTo("{\"$and\":[{\"name\": {\"$eq\":\"v1\"}}]}"));
    }

    @Test
    public void containsFilter()
    {
        Filters filters = new Filters();
        filters.setFilters(singletonList(new Filters.Filter("name", Arrays.asList("v1", "v2"), Filters.Matcher.CONTAINS)));

        assertThat(target.toJsonString(filters), equalTo("{\"$and\":[{\"name\": {\"$contains\":\"v1\"}}]}"));
    }
}