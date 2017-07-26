package com.smartling.connector.yext.sdk.data.response.product;

import com.smartling.connector.yext.sdk.data.ContentListCost;
import com.smartling.connector.yext.sdk.data.ContentListPhoto;

import java.util.List;

public class ProductItem
{

    private String description;

    private String id;

    private String name;

    private String url;

    private List<ContentListPhoto> photos;

    private String idcode;

    private ContentListCost cost;

    private String video;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public List<ContentListPhoto> getPhotos()
    {
        return photos;
    }

    public void setPhotos(List<ContentListPhoto> photos)
    {
        this.photos = photos;
    }

    public String getIdcode()
    {
        return idcode;
    }

    public void setIdcode(String idcode)
    {
        this.idcode = idcode;
    }

    public ContentListCost getCost()
    {
        return cost;
    }

    public void setCost(ContentListCost cost)
    {
        this.cost = cost;
    }

    public String getVideo()
    {
        return video;
    }

    public void setVideo(String video)
    {
        this.video = video;
    }

}

