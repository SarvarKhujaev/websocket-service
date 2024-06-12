package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;
import com.ssd.mvd.websocketservice.inspectors.LogInspector;
import com.ssd.mvd.websocketservice.constants.TaskTypes;
import com.ssd.mvd.websocketservice.constants.Status;
import com.ssd.mvd.websocketservice.constants.Topics;

import java.util.Date;
import java.util.UUID;

public final class Notification extends LogInspector implements ObjectCommonMethods {
    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public void changeTitle() {
        this.title = switch ( TaskTypes.valueOf( this.getType() ) ) {
            case CARD_102 -> "Sizga 102 tizimidan yangi vazifa biriktirildi";
            case FIND_FACE_CAR -> "Sizga qidiruvdagi avtomobil bo'yicha vazifa biriktirildi";
            case FIND_FACE_PERSON -> "Sizga qidiruvdagi shaxs bo'yicha vazifa biriktirildi";
            case FIND_FACE_EVENT_BODY, FIND_FACE_EVENT_FACE -> "Yangi e'lon xabari keldi";
            default -> this.getTitle();
        };
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getPassportSeries() {
        return this.passportSeries;
    }

    private String id; // id of any task
    private String type; // might be from 102 or Camera

    private String title; // description of Patrul action
    private String address;
    private String carNumber;
    private String policeType;
    private String nsfOfPatrul;
    private String passportSeries;

    private double latitudeOfTask;
    private double longitudeOfTask;

    private UUID uuid;
    private Status status;
    private Status taskStatus;

    private boolean wasRead;
    private TaskTypes taskTypes;
    private Date notificationWasCreated; // the date when this current notification was created

    @Override
    public String getTopicName() {
        if ( this.getStatus().isAttached() ) {
            this.changeTitle();
        }

        return Topics.NOTIFICATION.getName() + this.getPassportSeries();
    }

    @Override
    public void printMessage() {
        super.logging( "Notification: " + this.getStatus() ); // sending to front
    }
}
