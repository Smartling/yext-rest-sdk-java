package com.smartling.connector.yext.sdk.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.net.URL;

public final class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonUtils() {

    }

    public static <T> String toJsonString(T object) {
        try {
            MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return object == null ? null : MAPPER.writeValueAsString(object);
        } catch (Exception ex) {
            throw ExceptionUtils.toRuntimeException(ex);
        }
    }

    public static <T> T fromJsonByClassLoader(String classLoaderResource, Class<T> type) {
        return fromJson(
                Thread.currentThread().getContextClassLoader().getResource(classLoaderResource),
                type
        );
    }


    public static <T> T fromJson(URL urlToJson, Class<T> type) {
        try {
            return MAPPER.readValue(urlToJson, type);
        } catch (Exception ex) {
            throw ExceptionUtils.toRuntimeException(ex);
        }
    }

}
