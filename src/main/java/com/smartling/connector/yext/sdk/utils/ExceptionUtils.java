package com.smartling.connector.yext.sdk.utils;

public final class ExceptionUtils
{

    private ExceptionUtils()
    {
    }

    public static RuntimeException toRuntimeException(Throwable throwable)
    {
        return throwable instanceof RuntimeException ? (RuntimeException) throwable :
                new RuntimeException(throwable);
    }

    public static RuntimeException toRuntimeException(String message, Throwable throwable)
    {
        return message == null ? toRuntimeException(throwable) :
                new RuntimeException(message, throwable);
    }
}
