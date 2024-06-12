package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForPassport;

import com.ssd.mvd.websocketservice.constants.ErrorResponse;

@lombok.Data
public class ModelForPassport {
    private ErrorResponse errorResponse;
    private com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForPassport.Data Data;
}
