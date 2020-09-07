package com.smartling.connector.yext.sdk.data.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Meta
{
    private String uuid;
    private List<YextError> errors;
}
