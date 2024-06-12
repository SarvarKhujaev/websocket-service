package com.ssd.mvd.websocketservice.entity;

import java.util.UUID;

public final class ReqCar {
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
}
