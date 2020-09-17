package com.smartling.connector.yext.sdk.rest.api;

import com.smartling.connector.yext.sdk.data.response.folder.FoldersResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.ACCEPT_APPLICATION_JSON;

@Headers(ACCEPT_APPLICATION_JSON)
public interface FolderApi
{

    @RequestLine("GET /accounts/me/folders?entityTypes=location&access_token={access_token}&v={v}&limit={limit}&offset={offset}")
    FoldersResponse listFolders(@Param("access_token") String accessToken, @Param("v") String v,
                                @Param("limit") Integer limit, @Param("offset") Integer offset);

}
