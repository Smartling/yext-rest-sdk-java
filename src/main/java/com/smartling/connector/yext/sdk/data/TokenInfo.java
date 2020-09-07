package com.smartling.connector.yext.sdk.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenInfo
{
    @JsonProperty ("access_token")
    private String accessToken;
    private String accountName;
    private String appSpecificAccountId;
}
