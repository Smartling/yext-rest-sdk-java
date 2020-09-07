package com.smartling.connector.yext.sdk.data.request;

import com.smartling.connector.yext.sdk.data.response.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductWebHookRequest
{
    @Valid
    @NotNull
    private WebHookMeta meta;

    @Valid
    @NotNull
    private Product products;
}
