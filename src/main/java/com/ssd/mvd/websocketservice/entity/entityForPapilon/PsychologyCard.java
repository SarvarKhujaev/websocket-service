package com.ssd.mvd.websocketservice.entity.entityForPapilon;

import com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForAddress.ModelForAddress;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ssd.mvd.websocketservice.constants.ErrorResponse;

import java.util.List;

public final class PsychologyCard {
    @JsonDeserialize
    private Pinpp pinpp;
    private String personImage; // the image of the person

    @JsonDeserialize
    private List< PapilonData > papilonData;
    @JsonDeserialize
    private List< Violation > violationList;

    @JsonDeserialize
    private ModelForCarList modelForCarList; // the list of all cars which belongs to this person
    @JsonDeserialize
    private ModelForAddress modelForAddress;

    @JsonDeserialize
    private com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForCadastr.Data modelForCadastr;
    @JsonDeserialize
    private com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForPassport.Data modelForPassport;

    private ErrorResponse errorResponse;
}
