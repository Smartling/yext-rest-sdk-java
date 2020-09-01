package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.rest.YextRestAuthenticationException;
import com.smartling.connector.yext.sdk.rest.YextRestErrorDecoder;
import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class YextRestErrorDecoderTest
{
    private final YextRestErrorDecoder testedInstance = new YextRestErrorDecoder();

    @Test
    public void shouldReturnAuthenticationExceptionFor401() throws Exception
    {
        Request request = Request.create(Request.HttpMethod.GET, "http://yext.com", new HashMap<>(), new byte[0], Charset.forName("UTF-8"), new RequestTemplate());

        Response response = Response.builder()
                .status(401)
                .request(request)
                .reason("Unauthorized")
                .body(new byte[0])
                .build();

        Exception exception = testedInstance.decode("", response);

        assertThat(exception)
                .isExactlyInstanceOf(YextRestAuthenticationException.class)
                .hasMessage("Authentication failed with HTTP 401: Unauthorized. Details: null");
    }

}