package com.smartling.connector.yext.sdk.data.request.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SortProcessorTest
{
    @Test
    public void toJson()
    {
        List<Sort> sortList = Arrays.asList(new Sort("fieldOne", Sort.Order.ASCENDING),
                                            new Sort("fieldTwo", Sort.Order.DESCENDING));

        assertThat(SortProcessor.toJson(sortList), equalTo("[{\"fieldOne\": \"ASCENDING\"},{\"fieldTwo\": \"DESCENDING\"}]"));
    }
}