package com.smartling.connector.yext.sdk.data.response.menu;

public class MenuItem {

    private String description;

    private String id;

    private String name;

    private ContentListPhoto photo;

    private ContentListCost cost;

    private Calories calories;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContentListPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(ContentListPhoto photo) {
        this.photo = photo;
    }

    public ContentListCost getCost() {
        return cost;
    }

    public void setCost(ContentListCost cost) {
        this.cost = cost;
    }

    public Calories getCalories() {
        return calories;
    }

    public void setCalories(Calories calories) {
        this.calories = calories;
    }

}

