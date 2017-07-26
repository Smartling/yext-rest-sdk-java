package com.smartling.connector.yext.sdk.data;

import java.util.List;

public class ContentListCost
{

    private String price;

    private String other;

    private String rangeTo;

    private TypeEnum type;

    private List<ContentListCostOption> options;

    private String unit;

    public enum TypeEnum
    {

        PRICE("PRICE"),

        RANGE("RANGE"),

        NONE("NONE"),

        OTHER("OTHER");

        private String value;

        TypeEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getOther()
    {
        return other;
    }

    public void setOther(String other)
    {
        this.other = other;
    }

    public String getRangeTo()
    {
        return rangeTo;
    }

    public void setRangeTo(String rangeTo)
    {
        this.rangeTo = rangeTo;
    }

    public TypeEnum getType()
    {
        return type;
    }

    public void setType(TypeEnum type)
    {
        this.type = type;
    }

    public List<ContentListCostOption> getOptions()
    {
        return options;
    }

    public void setOptions(List<ContentListCostOption> options)
    {
        this.options = options;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

}

