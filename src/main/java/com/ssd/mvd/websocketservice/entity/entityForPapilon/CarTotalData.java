package com.ssd.mvd.websocketservice.entity.entityForPapilon;

import com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForGai.*;
import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;
import com.ssd.mvd.websocketservice.constants.ErrorResponse;
import com.ssd.mvd.websocketservice.inspectors.LogInspector;
import com.ssd.mvd.websocketservice.constants.Topics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

public final class CarTotalData extends LogInspector implements ObjectCommonMethods {
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

    @Override
    public String getTopicName() {
        return Topics.CAR_TOTAL_DATA.getName();
    }

    @Override
    public void printMessage() {
        super.logging( this.getClass().getName() + " : " + this.gosNumber + " was sent at: " + super.newDate() );
    }
}
