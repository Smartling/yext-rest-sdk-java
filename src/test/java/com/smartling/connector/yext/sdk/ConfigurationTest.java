package com.smartling.connector.yext.sdk;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest
{
    private Configuration configuration;

    @Before
    public void setup()
    {
        configuration = new Configuration("clientId", "clientSecret");
    }

    @Test(expected = NullPointerException.class)
    public void shouldValidateClientId() throws Exception
    {
        new Configuration(null, "clientSecret");
    }

    @Test(expected = NullPointerException.class)
    public void shouldValidateClientSecret() throws Exception
    {
        new Configuration("clientId", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateConnectionTimeout() throws Exception
    {
        configuration.setConnectTimeoutMillis(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateReadTimeout() throws Exception
    {
        configuration.setReadTimeoutMillis(-1);
    }

    @Test
    public void testGetOptions() throws Exception
    {
        assertThat(configuration.getOptions().connectTimeoutMillis()).isEqualTo(configuration.getConnectTimeoutMillis());
        assertThat(configuration.getOptions().readTimeoutMillis()).isEqualTo(configuration.getReadTimeoutMillis());
    }
}