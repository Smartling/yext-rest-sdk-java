package com.smartling.connector.yext.sdk;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class OAuthRequestInterceptor implements RequestInterceptor
{
    private final String headerValue;

    public OAuthRequestInterceptor (String accessToken)
    {
        headerValue = "Bearer " + accessToken;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", headerValue);
    }
}
