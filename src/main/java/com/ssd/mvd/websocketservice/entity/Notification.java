package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.TaskTypes;
import com.ssd.mvd.websocketservice.constants.Status;

import java.util.Date;
import java.util.UUID;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public final class Notification {
    private String id; // id of any task
    private String type; // might be from 102 or Camera
    private String title; // description of Patrul action
    private String address;
    private String carNumber;
    private String policeType;
    private String nsfOfPatrul;
    private String passportSeries;

    private Double latitudeOfTask;
    private Double longitudeOfTask;

    private UUID uuid;
    private Status status;
    private Status taskStatus;

    private Boolean wasRead;
    private TaskTypes taskTypes;
    private Date notificationWasCreated; // the date when this current notification was created
}
