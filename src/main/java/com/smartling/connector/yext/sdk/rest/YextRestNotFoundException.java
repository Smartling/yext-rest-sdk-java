package com.smartling.connector.yext.sdk.rest;

import feign.FeignException;

public class YextRestNotFoundException extends YextRestException
{

    public YextRestNotFoundException(final String message)
    {
        super(message);
    }

    public YextRestNotFoundException(final String message, final FeignException cause)
    {
        super(message, cause);
    }
}
