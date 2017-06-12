package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.OAuthConfiguration;
import com.smartling.connector.yext.sdk.OAuthRequestInterceptor;
import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.rest.YextRestErrorDecoder;
import feign.Feign;
import feign.Logger;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public abstract class ApiClient
{
    private TimeoutConfiguration timeoutConfiguration;
    final String accessToken;
    public static final String BASE_AUTH_API_URL = "https://api.yext.com/";
    public static final String BASE_API_URL = "https://api.yext.com/v2/";

    public ApiClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        this.timeoutConfiguration = timeoutConfiguration;
        this.accessToken = accessToken;
    }

    static <A> A buildApi(final Class<A> apiClass, final String apiBaseUrl, final OAuthConfiguration OAuthConfiguration)
    {
        return Feign.builder()
                    .encoder(new FormEncoder(new JacksonEncoder()))
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new YextRestErrorDecoder())
                    .options(OAuthConfiguration.getOptions())
                    .logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
                    .logLevel(Logger.Level.FULL)
                    .target(apiClass, apiBaseUrl);
    }

    protected <A> A buildApiWithOAuthAuthentication(final Class<A> apiClass, final String apiBaseUrl)
    {
        return Feign.builder()
                    .requestInterceptor(new OAuthRequestInterceptor(accessToken))
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .errorDecoder(new YextRestErrorDecoder())
                    .options(timeoutConfiguration.getOptions())
                    .logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
                    .logLevel(Logger.Level.FULL)
                    .target(apiClass, apiBaseUrl);
    }
}
