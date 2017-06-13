package com.smartling.connector.yext.sdk.data.response.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "A menu with sections")
public class Menu
{

    @ApiModelProperty(value = "List name.")
    private String name;

    @ApiModelProperty(example = "en", value = "List language in ISO 639-1 format. An ISO 3166-1 alpha-2 country code can optionally be appended to the language.  **Examples:** en, en_GB, fr_CA ")
    private String language;

    @ApiModelProperty(value = "List title that appears on listings.")
    private String title;

    @ApiModelProperty(value = "Indicates whether the List should be shown on your listings.")
    private Boolean publish;

    @ApiModelProperty(value = "ID of account that owns this List.")
    private String accountId;

    @ApiModelProperty(value = "List ID.")
    private String id;

    @ApiModelProperty(value = "Number of items in the List.")
    private Integer size;

    @ApiModelProperty(example = "USD", value = "The three-letter ISO 4217 currency code. Defaults to USD.")
    private String currency;

    @ApiModelProperty(value = "A list of sections.")
    private List<MenuSection> sections;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Boolean getPublish()
    {
        return publish;
    }

    public void setPublish(Boolean publish)
    {
        this.publish = publish;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public List<MenuSection> getSections()
    {
        return sections;
    }

    public void setSections(List<MenuSection> sections)
    {
        this.sections = sections;
    }

}


