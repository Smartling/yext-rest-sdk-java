package com.smartling.connector.yext.sdk.aspect;

import com.smartling.connector.yext.sdk.utils.JsonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.MDC;

import java.util.Arrays;

@Aspect
public class ParametersSaver
{
    @Before ("execution(public * com.smartling.connector.yext.sdk.client.*.*(..))")
    public void logBefore(JoinPoint joinPoint)
    {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Called for ").append( joinPoint.getSignature()).append(System.lineSeparator());
        stringBuilder.append("Args:").append(System.lineSeparator());
        Arrays.stream(joinPoint.getArgs()).forEach(object -> stringBuilder.append(JsonUtils.toJsonString(object)).append(System.lineSeparator()));
        MDC.put("lastRequest", stringBuilder.toString());
    }
}
