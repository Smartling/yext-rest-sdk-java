package com.smartling.connector.yext.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class RestApiUtils {

    public static final String ACCEPT_APPLICATION_JSON = "Accept: application/json";

    public static final String CONTENT_TYPE_APPLICATION_JSON = "Content-Type: application/json";

    private RestApiUtils() {

    }

    public static String generateV()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
        return format.format(cal.getTime());
    }

}
