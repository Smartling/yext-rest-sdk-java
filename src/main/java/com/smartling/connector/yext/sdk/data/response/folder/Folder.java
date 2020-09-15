package com.smartling.connector.yext.sdk.data.response.folder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Folder
{
    private String id;
    private String parentId;
    private String name;
}
