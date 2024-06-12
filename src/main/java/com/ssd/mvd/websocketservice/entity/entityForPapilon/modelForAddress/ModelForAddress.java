package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForAddress;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ssd.mvd.websocketservice.constants.ErrorResponse;
import lombok.extern.jackson.Jacksonized;
import java.util.List;

@lombok.Data
@Jacksonized
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class ModelForAddress {
    private ErrorResponse errorResponse;
    private PermanentRegistration PermanentRegistration;
    private com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForPassport.RequestGuid RequestGuid;
    @JsonDeserialize
    private List< com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForAddress.TemproaryRegistration > TemproaryRegistration;
}