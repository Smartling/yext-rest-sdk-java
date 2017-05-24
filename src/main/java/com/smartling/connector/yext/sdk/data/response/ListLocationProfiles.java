package com.smartling.connector.yext.sdk.data.response;

import com.smartling.connector.yext.sdk.data.Location;

import java.util.List;

public class ListLocationProfiles
{
    private List<Location> languageProfiles;

    public List<Location> getLanguageProfiles()
    {
        return languageProfiles;
    }

    public void setLanguageProfiles(final List<Location> languageProfiles)
    {
        this.languageProfiles = languageProfiles;
    }
}
