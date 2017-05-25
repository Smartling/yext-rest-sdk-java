package com.smartling.connector.yext.sdk;

import org.junit.Before;

import static org.junit.Assume.assumeNotNull;

public class BaseIntegrationTest
{
    protected TimeoutConfiguration timeoutConfiguration;

    protected String accessToken;

    @Before
    public void setUp() throws Exception
    {
        accessToken = System.getProperty("yext.accessToken");
        assumeNotNull("accessToken is not specified", accessToken);

        this.timeoutConfiguration = new TimeoutConfiguration();
    }

}
