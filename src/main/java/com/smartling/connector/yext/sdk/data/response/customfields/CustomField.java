package com.smartling.connector.yext.sdk.data.response.customfields;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomField
{
    private TranslatableValue description;

    public enum AlternateLanguageBehavior
    {
        PRIMARY_ONLY("PRIMARY_ONLY"),

        OVERRIDABLE("OVERRIDABLE"),

        LANGUAGE_SPECIFIC("LANGUAGE_SPECIFIC");

        private String value;

        AlternateLanguageBehavior(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }

    }

    private AlternateLanguageBehavior alternateLanguageBehavior;

    private String group;

    private TranslatableValue name;

    private List<CustomOption> options;

    private CustomValidation validation;

    public enum TypeEnum
    {

        BOOLEAN("BOOLEAN"),

        CALL_TO_ACTION("CALL_TO_ACTION"),

        DAILY_TIMES("DAILY_TIMES"),

        DATE("DATE"),

        GALLERY("GALLERY"),

        HOURS("HOURS"),

        ENTITY_LIST("ENTITY_LIST"),

        MULTILINE_TEXT("MULTILINE_TEXT"),

        MULTI_OPTION("MULTI_OPTION"),

        NUMBER("NUMBER"),

        PHOTO("PHOTO"),

        SIMPLE_PHOTO("SIMPLE_PHOTO"),

        RICH_TEXT("RICH_TEXT"),

        SINGLE_OPTION("SINGLE_OPTION"),

        TEXT("TEXT"),

        TEXT_LIST("TEXT_LIST"),

        URL("URL"),

        VIDEO("VIDEO"),

        VIDEO_GALLERY("VIDEO_GALLERY"),

        @JsonEnumDefaultValue
        UNKNOWN("UNKNOWN");

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

    private TypeEnum type;

    private String id;
}

