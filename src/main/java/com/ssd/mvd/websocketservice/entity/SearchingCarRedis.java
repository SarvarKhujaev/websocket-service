package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;
import com.ssd.mvd.websocketservice.inspectors.LogInspector;
import com.ssd.mvd.websocketservice.constants.Topics;

import java.util.Date;
import java.util.UUID;

public final class SearchingCarRedis extends LogInspector implements ObjectCommonMethods {
    private UUID id;
    private long regionId;
    private Date createdDate;

    private boolean state;
    private boolean person;

    private String name;
    private String file;
    private String color;
    private String photo;
    private String carType;
    private String policeId;
    private String stateCar;
    private String stateType;
    private String carNumber;
    private String definition;
    private String personType;
    private String description;

    @Override
    public String getTopicName() {
        return Topics.REDIS_CAR.getName();
    }

    @Override
    public void printMessage() {
        super.logging( "Got SearchingCarRedis: " + this );
    }
}

