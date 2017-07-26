package com.smartling.connector.yext.sdk.rest.api;

import com.smartling.connector.yext.sdk.data.response.EmptyResponse;
import com.smartling.connector.yext.sdk.data.response.IdResponse;
import com.smartling.connector.yext.sdk.data.response.product.Product;
import com.smartling.connector.yext.sdk.data.response.product.ProductResponse;
import com.smartling.connector.yext.sdk.data.response.product.ProductsResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.ACCEPT_APPLICATION_JSON;
import static com.smartling.connector.yext.sdk.utils.RestApiUtils.CONTENT_TYPE_APPLICATION_JSON;

@Headers(ACCEPT_APPLICATION_JSON)
public interface ProductApi
{

    @RequestLine("GET /accounts/me/products?access_token={access_token}&v={v}&limit={limit}&offset={offset}")
    ProductsResponse listProduct(@Param("access_token") String accessToken,
                                 @Param("v") String v,
                                 @Param("offset") Integer offset,
                                 @Param("limit") Integer limit);

    @RequestLine("GET /accounts/me/products/{productId}?access_token={access_token}&v={v}")
    ProductResponse getProductById(@Param("access_token") String accessToken,
                                   @Param("v") String v,
                                   @Param("productId") String productId);

    @Headers(CONTENT_TYPE_APPLICATION_JSON)
    @RequestLine("POST accounts/me/products?access_token={access_token}&v={v}")
    IdResponse createProduct(@Param("access_token") String accessToken,
                             @Param("v") String v,
                             Product product);

    @Headers(CONTENT_TYPE_APPLICATION_JSON)
    @RequestLine("PUT accounts/me/products/{productId}?access_token={access_token}&v={v}")
    ProductResponse updateProduct(@Param("access_token") String accessToken,
                                  @Param("v") String v,
                                  @Param("productId") String productId,
                                  Product product);

    @RequestLine("DELETE /accounts/me/products/{productId}?access_token={access_token}&v={v}")
    EmptyResponse deleteProductById(@Param("access_token") String accessToken,
                                    @Param("v") String v,
                                    @Param("productId") String productId);

}
