package com.ssd.mvd.websocketservice.entity.entityForPapilon;

import com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForGai.ModelForCar;
import com.ssd.mvd.websocketservice.constants.ErrorResponse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

public final class ModelForCarList {
    @JsonDeserialize
    private List< ModelForCar > modelForCarList;

    private ErrorResponse errorResponse;
}
