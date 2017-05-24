package com.smartling.connector.yext.sdk.rest;

import feign.FeignException;

public class YextRestAuthenticationException extends YextRestException
{
    public YextRestAuthenticationException(final String message)
    {
        super(message);
    }

    public YextRestAuthenticationException(final String message, final FeignException cause)
    {
        super(message, cause);
    }
}
