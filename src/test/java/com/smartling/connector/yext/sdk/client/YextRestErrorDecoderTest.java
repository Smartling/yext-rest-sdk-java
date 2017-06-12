package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.rest.YextRestAuthenticationException;
import com.smartling.connector.yext.sdk.rest.YextRestErrorDecoder;
import feign.Response;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class YextRestErrorDecoderTest
{
    private final YextRestErrorDecoder testedInstance = new YextRestErrorDecoder();

    @Test
    public void shouldReturnAuthenticationExceptionFor401() throws Exception
    {
        Response response = Response.create(401, "Unauthorized", Collections.emptyMap(), new byte[0]);

        Exception exception = testedInstance.decode("", response);

        assertThat(exception)
                .isExactlyInstanceOf(YextRestAuthenticationException.class)
                .hasMessage("Authentication failed with HTTP 401: Unauthorized. Details: null");
    }

}