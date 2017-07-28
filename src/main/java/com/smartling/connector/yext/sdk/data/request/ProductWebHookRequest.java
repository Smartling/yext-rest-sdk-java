package com.smartling.connector.yext.sdk.data.request;

import com.smartling.connector.yext.sdk.data.response.product.Product;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ProductWebHookRequest
{

    @Valid
    @NotNull
    private WebHookMeta meta;

    @Valid
    @NotNull
    private Product products;

    public WebHookMeta getMeta()
    {
        return meta;
    }

    public void setMeta(WebHookMeta meta)
    {
        this.meta = meta;
    }

    public Product getProducts()
    {
        return products;
    }

    public void setProducts(Product products)
    {
        this.products = products;
    }

}
