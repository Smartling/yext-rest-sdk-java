package com.smartling.connector.yext.sdk.data.response.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta
{
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String countryCode;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String folderId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Object> labels = new ArrayList<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String language;
    private String uid;
}
