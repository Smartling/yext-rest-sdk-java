package com.smartling.connector.yext.sdk.rest;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class YextRestErrorDecoder implements ErrorDecoder
{
    private static final Logger LOGGER = LoggerFactory.getLogger(YextRestErrorDecoder.class);

    @Override
    public Exception decode(final String methodKey, final Response response)
    {
        LOGGER.debug("Exception during execution of method {}", MDC.get("lastRequest"));
        String responseBody = bodyAsString(response);

        if (response.status() == 401)
        {
            String message = String.format("Authentication failed with HTTP %s: %s. Details: %s", response.status(), response.reason(), responseBody);
            return new YextRestAuthenticationException(message);
        }

        if (response.status() == 404)
        {
            String message = String.format("Authentication failed with HTTP %s: %s. Details: %s", response.status(), response.reason(), responseBody);
            return new YextRestNotFoundException(message);
        }

        String message = String.format("Yext API responded with HTTP %s: %s. Details: %s", response.status(), response.reason(), responseBody);
        return new YextRestException(message);
    }

    private static String bodyAsString(final Response response)
    {
        if (response != null && response.body() != null && response.body().length() !=null && response.body().length() > 0)
        {
            try (BufferedReader reader = new BufferedReader(response.body().asReader()))
            {
                return reader.lines().collect(Collectors.joining());
            }
            catch (IOException e)
            {
                LOGGER.warn("Failed to read response:", e);
                return null;
            }
        }
        else
        {
            return null;
        }
    }
}
