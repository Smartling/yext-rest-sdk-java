package com.smartling.connector.yext.sdk;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OAuthConfigurationTest
{
    private OAuthConfiguration OAuthConfiguration;

    @Before
    public void setup()
    {
        OAuthConfiguration = new OAuthConfiguration("clientId", "clientSecret", "111");
    }

    @Test(expected = NullPointerException.class)
    public void shouldValidateClientId() throws Exception
    {
        new OAuthConfiguration(null, "clientSecret", "111");
    }

    @Test(expected = NullPointerException.class)
    public void shouldValidateClientSecret() throws Exception
    {
        new OAuthConfiguration("clientId", null, "111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateConnectionTimeout() throws Exception
    {
        OAuthConfiguration.setConnectTimeoutMillis(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldValidateReadTimeout() throws Exception
    {
        OAuthConfiguration.setReadTimeoutMillis(-1);
    }

    @Test
    public void testGetOptions() throws Exception
    {
        assertThat(OAuthConfiguration.getOptions().connectTimeoutMillis()).isEqualTo(OAuthConfiguration.getConnectTimeoutMillis());
        assertThat(OAuthConfiguration.getOptions().readTimeoutMillis()).isEqualTo(OAuthConfiguration.getReadTimeoutMillis());
    }
}