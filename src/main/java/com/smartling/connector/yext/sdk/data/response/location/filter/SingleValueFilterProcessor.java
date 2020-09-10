package com.smartling.connector.yext.sdk.data.response.location.filter;

import com.smartling.connector.yext.sdk.data.response.location.Filters;
import com.smartling.connector.yext.sdk.utils.CollectionUtils;

public class SingleValueFilterProcessor implements FilterProcessor
{
    @Override
    public String toJsonString(Filters.Filter filter)
    {
        String values = CollectionUtils.isEmpty(filter.getValues()) ? "" : FilterProcessor.valueToString(filter.getValues().get(0));

        return String.format(JSON_FORMAT, filter.getField(), filter.getMatcher().getValue(), values);
    }
}
