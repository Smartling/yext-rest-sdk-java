
package com.smartling.connector.yext.sdk.data;

import java.util.List;

public class FacebookProfilePicture
{

    private String url;

    private String description;

    private String alternateText;

    private Integer width;

    private Integer height;

    private List<Derivative> derivatives;

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getAlternateText()
    {
        return alternateText;
    }

    public void setAlternateText(String alternateText)
    {
        this.alternateText = alternateText;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public List<Derivative> getDerivatives()
    {
        return derivatives;
    }

    public void setDerivatives(List<Derivative> derivatives)
    {
        this.derivatives = derivatives;
    }

}
