package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.CustomFieldsClient;
import com.smartling.connector.yext.sdk.data.response.customfields.CustomFieldsResponse;
import com.smartling.connector.yext.sdk.data.response.customfields.ListCustomFields;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomFieldsIntegrationTest extends BaseIntegrationTest
{

    @Test
    public void listCustomFields()
    {
        getCustomFieldsList(customFieldsClient());
    }

    private static ListCustomFields getCustomFieldsList(CustomFieldsClient client)
    {
        final int offset = 0;
        final int limit = 50;
        CustomFieldsResponse customFieldsResponse = client.listCustomFields(offset, limit);
        assertThat(customFieldsResponse).isNotNull();

        ListCustomFields result = customFieldsResponse.getResponse();
        assertThat(result).isNotNull();
        assertThat(result.getCount()).isGreaterThan(0);
        assertThat(result.getCustomFields()).isNotEmpty();

        return result;
    }

}
