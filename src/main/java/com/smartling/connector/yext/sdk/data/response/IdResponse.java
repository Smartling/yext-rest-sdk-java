package com.smartling.connector.yext.sdk.data.response;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Optional;

public class IdResponse extends YextResponse<Id> {

    @JsonIgnore
    public String getIdAsString() {
        return Optional.ofNullable(getResponse()).map(Id::getId).orElse(null);
    }

}
