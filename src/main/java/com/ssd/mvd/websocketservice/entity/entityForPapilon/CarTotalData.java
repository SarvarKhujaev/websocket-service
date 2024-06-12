package com.ssd.mvd.websocketservice.entity.entityForPapilon;

import com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForGai.*;
import com.ssd.mvd.websocketservice.constants.ErrorResponse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

public final class CarTotalData {
    private String gosNumber;
    private String cameraImage; // image which was made by camera

    @JsonDeserialize
    private Tonirovka tonirovka;
    @JsonDeserialize
    private Insurance insurance;
    @JsonDeserialize
    private ModelForCar modelForCar;
    @JsonDeserialize
    private PsychologyCard psychologyCard;
    @JsonDeserialize
    private ViolationsList violationsList;
    @JsonDeserialize
    private DoverennostList doverennostList;
    @JsonDeserialize
    private ModelForCarList modelForCarList; // the list of all cars of each citizen

    @JsonDeserialize
    private List< String > patruls; // link to list of Patruls who is going deal with this Card
    @JsonDeserialize
    private List< ReportForCard > reportForCards;

    private ErrorResponse errorResponse;
}
