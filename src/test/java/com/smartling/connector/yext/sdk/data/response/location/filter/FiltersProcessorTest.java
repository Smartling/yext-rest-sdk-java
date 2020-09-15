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
    public void eqFilter()
    {
        Filters filters = new Filters();
        filters.setFilters(singletonList(new Filters.Filter("name", Arrays.asList("v1", "v2"), Filters.Matcher.EQ)));

        assertThat(target.toJsonString(filters), equalTo("{\"$and\":[{\"$or\":[{\"name\": {\"$eq\":\"v1\"}},{\"name\": {\"$eq\":\"v2\"}}]}]}"));
    }

    @Test
    public void containsFilter()
    {
        Filters filters = new Filters();
        filters.setFilters(singletonList(new Filters.Filter("name", Arrays.asList("v1", "v2"), Filters.Matcher.CONTAINS)));

        assertThat(target.toJsonString(filters), equalTo("{\"$and\":[{\"$or\":[{\"name\": {\"$contains\":\"v1\"}},{\"name\": {\"$contains\":\"v2\"}}]}]}"));
    }
}