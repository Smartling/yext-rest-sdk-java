package com.smartling.connector.yext.sdk.data.response.menu;

public class Calories {

    private Integer calorie;

    private Integer rangeTo;

    private TypeEnum type;

    public enum TypeEnum {

        FIXED("FIXED"),

        RANGE("RANGE");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public Integer getRangeTo() {
        return rangeTo;
    }

    public void setRangeTo(Integer rangeTo) {
        this.rangeTo = rangeTo;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

}

