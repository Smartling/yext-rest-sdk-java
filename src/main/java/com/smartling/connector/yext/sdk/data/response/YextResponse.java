package com.smartling.connector.yext.sdk.data.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class YextResponse<A>
{
    private Meta meta;
    private A response;
}
