package com.smartling.connector.yext.sdk;

import com.smartling.connector.yext.sdk.client.MenuClient;
import org.junit.Before;

import static org.junit.Assert.assertNotNull;


public class BaseIntegrationTest {
    protected TimeoutConfiguration timeoutConfiguration;

    protected String accessToken;

    @Before
    public void setUp() throws Exception {
        accessToken = System.getProperty("yext.accessToken");
        assertNotNull("accessToken is not specified", accessToken);

        this.timeoutConfiguration = new TimeoutConfiguration();
    }

    public MenuClient menuClient() {
        return new MenuClient(timeoutConfiguration, accessToken);
    }

}
