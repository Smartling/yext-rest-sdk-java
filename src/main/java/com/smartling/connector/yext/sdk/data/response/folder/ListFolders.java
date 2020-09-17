package com.smartling.connector.yext.sdk.data.response.folder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListFolders
{
    private Integer count;
    private List<Folder> folders;
}
