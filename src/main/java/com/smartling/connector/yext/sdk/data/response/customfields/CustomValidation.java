package com.smartling.connector.yext.sdk.data.response.customfields;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
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
}

