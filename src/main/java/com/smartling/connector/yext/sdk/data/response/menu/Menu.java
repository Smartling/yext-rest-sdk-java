package com.smartling.connector.yext.sdk.data.response.menu;

import java.util.List;

public class Menu {

    private String name;

    private String language;

    private String title;

    private Boolean publish;

    private String accountId;

    private String id;

    private Integer size;

    private String currency;

    private List<MenuSection> sections;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<MenuSection> getSections() {
        return sections;
    }

    public void setSections(List<MenuSection> sections) {
        this.sections = sections;
    }

}


