package com.smartling.connector.yext.sdk.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class RestApiUtils {

    private RestApiUtils() {

    }

    public static String generateV()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
        return format.format(cal.getTime());
    }

}
