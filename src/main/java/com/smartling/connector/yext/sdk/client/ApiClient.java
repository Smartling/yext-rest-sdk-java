package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.Configuration;
import com.smartling.connector.yext.sdk.OAuthRequestInterceptor;
import feign.Feign;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public abstract class ApiClient
{
    private Configuration configuration;
    final String accessToken;
    public static final String BASE_AUTH_API_URL = "https://api.yext.com/";
    public static final String BASE_API_URL = "https://api.yext.com/v2/";

    public ApiClient(final Configuration configuration, String accessToken)
    {
        this.configuration = configuration;
        this.accessToken = accessToken;
    }

    static <A> A buildApi(final Class<A> apiClass, final String apiBaseUrl, final Configuration configuration)
    {
        return Feign.builder()
                    .encoder(new FormEncoder(new JacksonEncoder()))
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new YextRestErrorDecoder())
                    .options(configuration.getOptions())
                    .target(apiClass, apiBaseUrl);
    }

    protected <A> A buildApiWithOAuthAuthentication(final Class<A> apiClass, final String apiBaseUrl)
    {
        return Feign.builder()
                    .requestInterceptor(new OAuthRequestInterceptor(accessToken))
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new YextRestErrorDecoder())
                    .options(configuration.getOptions())
                    .target(apiClass, apiBaseUrl);
    }
}
