package com.smartling.connector.yext.sdk.rest;

import feign.FeignException;

public class YextRestException extends RuntimeException
{
    public YextRestException(final String message)
    {
        super(message);
    }

    public YextRestException(final String message, final FeignException cause)
    {
        super(message, cause);
    }

}
