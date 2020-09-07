package com.smartling.connector.yext.sdk.data.response.customfields;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TranslatableValue
{
    private String value;
    private List<CustomTranslation> translations;
}
