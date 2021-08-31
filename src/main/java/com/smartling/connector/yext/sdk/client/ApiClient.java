package com.smartling.connector.yext.sdk.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartling.connector.yext.sdk.OAuthConfiguration;
import com.smartling.connector.yext.sdk.OAuthRequestInterceptor;
import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.rest.YextRestErrorDecoder;
import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public abstract class ApiClient
{
    public static final String BASE_AUTH_API_URL = "https://api.yext.com/";
    public static final String BASE_API_URL = "https://api.yext.com/v2/";

    private final TimeoutConfiguration timeoutConfiguration;
    private final ObjectMapper objectMapper;
    final String accessToken;

    public ApiClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        this.timeoutConfiguration = timeoutConfiguration;
        this.accessToken = accessToken;
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE, true);

    }

    static <A> A buildApi(final Class<A> apiClass, final String apiBaseUrl, final OAuthConfiguration OAuthConfiguration)
    {
        return Feign.builder()
                    .encoder(new FormEncoder(new JacksonEncoder()))
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new YextRestErrorDecoder())
                    .options(OAuthConfiguration.getOptions())
                    .target(apiClass, apiBaseUrl);
    }

    protected <A> A buildApiWithOAuthAuthentication(final Class<A> apiClass, final String apiBaseUrl)
    {
        return Feign.builder()
                    .requestInterceptor(new OAuthRequestInterceptor(accessToken))
                    .encoder(new JacksonEncoder(objectMapper))
                    .decoder(new JacksonDecoder(objectMapper))
                    .errorDecoder(new YextRestErrorDecoder())
                    .options(timeoutConfiguration.getOptions())
                    .target(apiClass, apiBaseUrl);
    }
}
