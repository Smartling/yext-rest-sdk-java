package com.smartling.connector.yext.sdk.client;

import com.smartling.connector.yext.sdk.TimeoutConfiguration;
import com.smartling.connector.yext.sdk.data.response.folder.FoldersResponse;
import com.smartling.connector.yext.sdk.rest.api.FolderApi;

import static com.smartling.connector.yext.sdk.utils.RestApiUtils.generateV;

public class FolderClient extends ApiClient
{
    private FolderApi folderApi;

    public FolderClient(final TimeoutConfiguration timeoutConfiguration, String accessToken)
    {
        super(timeoutConfiguration, accessToken);
        folderApi = buildApiWithOAuthAuthentication(FolderApi.class, BASE_API_URL);
    }

    public FoldersResponse listFoldres(int offset, int limit)
    {
        return folderApi.listFolders(accessToken, generateV(), limit, offset);
    }
}
