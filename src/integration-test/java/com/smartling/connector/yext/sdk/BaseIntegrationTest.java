package com.smartling.connector.yext.sdk;

import org.junit.Before;

import static org.junit.Assume.assumeNotNull;

public class BaseIntegrationTest
{
    protected Configuration configuration;

    protected String userId;
    protected String userSecret;
    protected String accessToken;

    @Before
    public void setUp() throws Exception
    {
        userId = System.getProperty("yext.userId");
        userSecret = System.getProperty("yext.userSecret");
        accessToken = System.getProperty("yext.accessToken");
        assumeNotNull("userId is not specified", userId);
        assumeNotNull("userSecret is not specified", userSecret);
        assumeNotNull("accessToken is not specified", accessToken);

        this.configuration = new Configuration(userId, userSecret);
    }

}
