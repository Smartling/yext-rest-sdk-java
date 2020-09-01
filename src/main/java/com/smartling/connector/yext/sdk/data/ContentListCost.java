package com.smartling.connector.yext.sdk.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
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
}

