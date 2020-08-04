package com.smartling.connector.yext.sdk.data.response.customfields;

import java.util.List;

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

    public enum GroupEnum
    {

        NONE("NONE"),

        GROUP_1("GROUP_1"),

        GROUP_2("GROUP_2"),

        GROUP_3("GROUP_3"),

        GROUP_4("GROUP_4"),

        GROUP_5("GROUP_5"),

        GROUP_6("GROUP_6"),

        GROUP_7("GROUP_7"),

        GROUP_8("GROUP_8"),

        GROUP_9("GROUP_9"),

        GROUP_10("GROUP_10");

        private String value;

        GroupEnum(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }

    private GroupEnum group;

    private TranslatableValue name;

    private List<CustomOption> options;

    private CustomValidation validation;

    public enum TypeEnum
    {

        BOOLEAN("BOOLEAN"),

        CTA("CTA"),

        DAILY_TIMES("DAILY_TIMES"),

        DATE("DATE"),

        GALLERY("GALLERY"),

        HOURS("HOURS"),

        ENTITY_LIST("ENTITY_LIST"),

        MULTILINE_TEXT("MULTILINE_TEXT"),

        MULTI_OPTION("MULTI_OPTION"),

        NUMBER("NUMBER"),

        PHOTO("PHOTO"),

        RICH_TEXT("RICH_TEXT"),

        SINGLE_OPTION("SINGLE_OPTION"),

        TEXT("TEXT"),

        TEXT_LIST("TEXT_LIST"),

        URL("URL"),

        VIDEO("VIDEO"),

        VIDEO_GALLERY("VIDEO_GALLERY");

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

    public TranslatableValue getDescription()
    {
        return description;
    }

    public void setDescription(TranslatableValue description)
    {
        this.description = description;
    }

    public AlternateLanguageBehavior getAlternateLanguageBehavior()
    {
        return alternateLanguageBehavior;
    }

    public void setAlternateLanguageBehavior(AlternateLanguageBehavior alternateLanguageBehavior)
    {
        this.alternateLanguageBehavior = alternateLanguageBehavior;
    }

    public GroupEnum getGroup()
    {
        return group;
    }

    public void setGroup(GroupEnum group)
    {
        this.group = group;
    }

    public TranslatableValue getName()
    {
        return name;
    }

    public void setName(TranslatableValue name)
    {
        this.name = name;
    }

    public List<CustomOption> getOptions()
    {
        return options;
    }

    public void setOptions(List<CustomOption> options)
    {
        this.options = options;
    }

    public CustomValidation getValidation()
    {
        return validation;
    }

    public void setValidation(CustomValidation validation)
    {
        this.validation = validation;
    }

    public TypeEnum getType()
    {
        return type;
    }

    public void setType(TypeEnum type)
    {
        this.type = type;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}

