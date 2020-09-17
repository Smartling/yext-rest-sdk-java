package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.response.customfields.CustomFieldResponse;
import com.smartling.connector.yext.sdk.data.response.customfields.CustomFieldsResponse;
import com.smartling.connector.yext.sdk.rest.api.CustomFieldsApi;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.generateV;

public class CustomFieldsClient extends ApiClient
{

    private CustomFieldsApi customFieldsApi;

    public CustomFieldsClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        super(timeoutConfiguration, accessToken);
        customFieldsApi = buildApiWithOAuthAuthentication(CustomFieldsApi.class, BASE_API_URL);
    }

    public CustomFieldsResponse listCustomFields(int offset, int limit)
    {
        return customFieldsApi.listCustomFields(accessToken, generateV(), offset, limit);
    }

    public CustomFieldResponse getCustomField(String fieldId)
    {
        return customFieldsApi.getCustomField(accessToken, generateV(), fieldId);
    }

}
