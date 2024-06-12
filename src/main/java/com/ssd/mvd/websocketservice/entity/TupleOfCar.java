package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;
import com.ssd.mvd.websocketservice.inspectors.LogInspector;
import com.ssd.mvd.websocketservice.constants.Topics;

import java.util.UUID;

public final class TupleOfCar extends LogInspector implements ObjectCommonMethods {
    private UUID uuid;
    private UUID uuidOfEscort; // UUID of the Escort which this car is linked to
    private UUID uuidOfPatrul; // UUID of the Escort which this car is linked to

    private String carModel;
    private String gosNumber;
    private String trackerId;
    private String nsfOfPatrul;
    private String simCardNumber;

    private double latitude;
    private double longitude;
    private double averageFuelConsumption;

    @Override
    public String getTopicName() {
        return Topics.NEW_TUPLE_OF_CAR_TOPIC.getName();
    }

    @Override
    public void printMessage() {
        super.logging( this.getClass().getName() + " for: " + this.uuid );
    }
}
