package com.smartling.connector.yext.sdk.data.response;

public class YextResponse<A>
{
    private Meta meta;
    private A response;

    public Meta getMeta()
    {
        return meta;
    }

    public void setMeta(final Meta meta)
    {
        this.meta = meta;
    }

    public A getResponse()
    {
        return response;
    }

    public void setResponse(final A response)
    {
        this.response = response;
    }
}
