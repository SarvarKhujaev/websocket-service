package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForAddress;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true )
public class pRegion {
    private Integer Id;
    private String value;
    private String IdValue;
}
