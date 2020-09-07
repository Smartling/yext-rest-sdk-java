package com.smartling.connector.yext.sdk.data.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class YextError
{
    private String code;
    private String type;
    private String message;
}
