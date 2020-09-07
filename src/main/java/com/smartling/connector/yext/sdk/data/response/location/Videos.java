package com.smartling.connector.yext.sdk.data.response.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Videos
{
    private Video video;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Video {
        private String url;
    }
}
