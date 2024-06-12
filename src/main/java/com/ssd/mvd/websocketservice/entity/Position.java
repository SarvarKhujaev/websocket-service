package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.Status;
import java.util.Date;
import java.util.UUID;

public class Position {
    public long getRegionId() {
        return this.regionId;
    }

    public long getMahallaId() {
        return this.mahallaId;
    }

    public long getDistrictId() {
        return this.districtId;
    }

    // only for Car
    private String icon; // иконка патрульного выбирается исходя из типа патрульного
    private String icon2; // иконка патрульного выбирается исходя из типа патрульного
    private String carType;
    private String carGosNumber;

    // only for Patrul
    private String taskId;
    private String patrulName;
    private String policeType;

    private Status status;
    private UUID patrulUUID;

    private double latitudeOfTask;
    private double longitudeOfTask;

    private long regionId;
    private long mahallaId;
    private long districtId; // choosing from dictionary

    // Tracker data
    private String deviceId;
    private Date deviceTime;

    private double speed; // value in knots
    private double latitude;
    private double longitude;
}
