package com.smartling.connector.yext.sdk.data.response.customfields;

import java.util.List;

public class TranslatableValue
{
    private String value;
    private List<CustomTranslation> translations;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public List<CustomTranslation> getTranslations()
    {
        return translations;
    }

    public void setTranslations(List<CustomTranslation> translations)
    {
        this.translations = translations;
    }
}
