package com.smartling.connector.yext.sdk.data.response.customfields;

import java.math.BigDecimal;

public class CustomValidation
{

    private String maxDate;

    private Integer minHeight;

    private BigDecimal maxValue;

    private BigDecimal minValue;

    private Integer minWidth;

    private Integer minCharLength;

    private Integer maxItemCount;

    private Integer minItemCount;

    private Integer maxCharLength;

    public enum AspectRatioEnum
    {

        UNCONSTRAINED("UNCONSTRAINED"),

        _1_1("1:1"),

        _4_3("4:3"),

        _3_2("3:2"),

        _5_3("5:3"),

        _16_9("16:9"),

        _3_1("3:1"),

        _2_3("2:3"),

        _5_7("5:7"),

        _4_5("4:5"),

        _4_1("4:1");

        private String value;

        AspectRatioEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private AspectRatioEnum aspectRatio;

    private String minDate;

    public String getMaxDate()
    {
        return maxDate;
    }

    public void setMaxDate(String maxDate)
    {
        this.maxDate = maxDate;
    }

    public Integer getMinHeight()
    {
        return minHeight;
    }

    public void setMinHeight(Integer minHeight)
    {
        this.minHeight = minHeight;
    }

    public BigDecimal getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue)
    {
        this.maxValue = maxValue;
    }

    public BigDecimal getMinValue()
    {
        return minValue;
    }

    public void setMinValue(BigDecimal minValue)
    {
        this.minValue = minValue;
    }

    public Integer getMinWidth()
    {
        return minWidth;
    }

    public void setMinWidth(Integer minWidth)
    {
        this.minWidth = minWidth;
    }

    public Integer getMinCharLength()
    {
        return minCharLength;
    }

    public void setMinCharLength(Integer minCharLength)
    {
        this.minCharLength = minCharLength;
    }

    public Integer getMaxItemCount()
    {
        return maxItemCount;
    }

    public void setMaxItemCount(Integer maxItemCount)
    {
        this.maxItemCount = maxItemCount;
    }

    public Integer getMinItemCount()
    {
        return minItemCount;
    }

    public void setMinItemCount(Integer minItemCount)
    {
        this.minItemCount = minItemCount;
    }

    public Integer getMaxCharLength()
    {
        return maxCharLength;
    }

    public void setMaxCharLength(Integer maxCharLength)
    {
        this.maxCharLength = maxCharLength;
    }

    public AspectRatioEnum getAspectRatio()
    {
        return aspectRatio;
    }

    public void setAspectRatio(AspectRatioEnum aspectRatio)
    {
        this.aspectRatio = aspectRatio;
    }

    public String getMinDate()
    {
        return minDate;
    }

    public void setMinDate(String minDate)
    {
        this.minDate = minDate;
    }

}

