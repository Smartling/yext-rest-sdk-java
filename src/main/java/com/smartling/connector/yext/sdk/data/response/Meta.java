package com.smartling.connector.yext.sdk.data.response;

import java.util.List;

public class Meta
{
    private String uuid;
    private List<YextError> errors;

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(final String uuid)
    {
        this.uuid = uuid;
    }

    public List<YextError> getErrors()
    {
        return errors;
    }

    public void setErrors(final List<YextError> errors)
    {
        this.errors = errors;
    }
}
