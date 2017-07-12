package com.smartling.connector.yext.sdk.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import java.net.URL;

public final class JsonUtils
{

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static
    {
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JsonUtils()
    {

    }

    public static <T> String toJsonString(T object)
    {
        return toJsonString(MAPPER, object);
    }

    public static <T> String toJsonStringIgnorePropertyAccess(T object) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();

        mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector()
        {
            @Override
            public JsonProperty.Access findPropertyAccess(Annotated m)
            {
                return null;
            }
        });

        return toJsonString(mapper, object);
    }

    private static <T> String toJsonString(ObjectMapper mapper, T object)
    {
        try
        {
            return object == null ? null : mapper.writeValueAsString(object);
        } catch (Exception ex)
        {
            throw ExceptionUtils.toRuntimeException(ex);
        }
    }

    public static <T> T fromJsonByClassLoader(String classLoaderResource, Class<T> type)
    {
        return fromJson(
                Thread.currentThread().getContextClassLoader().getResource(classLoaderResource),
                type
        );
    }


    public static <T> T fromJson(URL urlToJson, Class<T> type)
    {
        try
        {
            return MAPPER.readValue(urlToJson, type);
        } catch (Exception ex)
        {
            throw ExceptionUtils.toRuntimeException(ex);
        }
    }

}
