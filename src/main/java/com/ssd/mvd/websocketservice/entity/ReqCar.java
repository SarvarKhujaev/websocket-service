package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;
import com.ssd.mvd.websocketservice.inspectors.LogInspector;
import com.ssd.mvd.websocketservice.constants.Topics;
import java.util.UUID;

public final class ReqCar extends LogInspector implements ObjectCommonMethods {
    private UUID lustraId;
    private String gosNumber;
    private String trackerId;
    private String vehicleType;
    private String carImageLink;
    private String patrulPassportSeries;

    private int sideNumber; // бортовой номер
    private int simCardNumber;

    private double latitude;
    private double longitude;
    private double averageFuelSize; // средний расход топлива по документам
    private double averageFuelConsumption = 0.0; // средний расход топлива исходя из стиля вождения водителя

    @Override
    public String getTopicName() {
        return Topics.NEW_CAR_TOPIC.getName();
    }

    @Override
    public void printMessage() {
        super.logging( "Message from car: " + this.gosNumber );
    }
}
