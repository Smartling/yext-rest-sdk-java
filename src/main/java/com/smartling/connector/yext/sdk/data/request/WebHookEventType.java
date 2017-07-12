package com.smartling.connector.yext.sdk.data.request;

public enum WebHookEventType
{

    ACCOUNT_UNLINKED,

    LOCATION_CREATED,

    LOCATION_UPDATED,

    MENU_CREATED,

    MENU_UPDATED,

    MENU_DELETED;

    public static boolean isUpdateEvent(WebHookEventType eventType)
    {
        return eventType == LOCATION_UPDATED || eventType == MENU_UPDATED;
    }

}
