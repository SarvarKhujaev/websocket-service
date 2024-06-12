package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.TaskTypes;
import com.ssd.mvd.websocketservice.constants.Status;
import java.util.UUID;

public final class ReqLocationExchange {
    public long getRegionId() {
        return regionId;
    }

    public long getMahallaId() {
        return mahallaId;
    }

    public long getDistrictId() {
        return districtId;
    }

    private Status status;
    private UUID patrulUUID;
    private boolean sosStatus; // показывает послал ли патрульный сос сигнал
    private TaskTypes taskTypes;

    private String card;
    private String icon;
    private String icon2;
    private String patrulName;
    private String policeType;
    private String patrulPassportSeries;

    private double latitudeOfTask;
    private double longitudeOfTask;

    private long regionId;
    private long mahallaId;
    private long districtId; // choosing from dictionary

    // original values from each Tablet
    private double longitude;
    private double latitude;

    private long date;
    private int speed; // скорось передвижения патрулього
    private int batteryLevel;
}
