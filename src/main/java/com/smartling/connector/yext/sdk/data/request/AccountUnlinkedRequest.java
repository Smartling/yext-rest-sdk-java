package com.smartling.connector.yext.sdk.data.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class AccountUnlinkedRequest
{
    @Valid
    @NotNull
    private WebHookMeta meta;
}
