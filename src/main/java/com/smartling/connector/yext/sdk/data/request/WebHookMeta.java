package com.smartling.connector.yext.sdk.data.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class WebHookMeta
{

    @NotNull
    private WebHookEventType eventType;

    private String uuid;

    private String timestamp;

    private String accountId;

    private String actor;

    @NotNull
    private String appSpecificAccountId;
}
