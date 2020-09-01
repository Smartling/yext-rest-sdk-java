package com.smartling.connector.yext.sdk.data.response.menu;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}

