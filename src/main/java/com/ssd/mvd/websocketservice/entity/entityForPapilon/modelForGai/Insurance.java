package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForGai;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ssd.mvd.websocketservice.constants.ErrorResponse;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Insurance {
    private String DateBegin;
    private String DateValid;
    private String InsuranceSerialNumber;

    @JsonDeserialize
    private ErrorResponse errorResponse;
}
