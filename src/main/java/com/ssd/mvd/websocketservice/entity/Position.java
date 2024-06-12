package com.ssd.mvd.websocketservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ssd.mvd.websocketservice.constants.Status;

import java.util.Date;
import java.util.UUID;

@lombok.Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class Position {
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

    private Double latitudeOfTask;
    private Double longitudeOfTask;

    private Long regionId;
    private Long mahallaId;
    private Long districtId; // choosing from dictionary

    // Tracker data
    private String deviceId;
    private Date deviceTime;

    private Double speed; // value in knots
    private Double latitude;
    private Double longitude;
}
