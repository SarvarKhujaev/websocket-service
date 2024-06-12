package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.Status;
import com.ssd.mvd.websocketservice.constants.Topics;
import com.ssd.mvd.websocketservice.inspectors.LogInspector;
import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;

public final class SosNotificationForAndroid extends LogInspector implements ObjectCommonMethods {
    public Status getStatus() {
        return this.status;
    }

    public String getPatrulPassportSeries() {
        return this.patrulPassportSeries;
    }

    private Status status;
    private double latitude;
    private double longitude;

    private long regionId;
    private long mahallaId;
    private long districtId; // choosing from dictionary

    private String rank;
    private String address;
    private String dateOfBirth;
    private String phoneNumber;
    private String patrulImageLink;

    private String patrulPassportSeries;
    private String surnameNameFatherName; // Ф.И.О

    @Override
    public String getTopicName() {
        return Topics.SOS_TOPIC_FOR_ANDROID_NOTIFICATION.getName();
    }

    @Override
    public void printMessage() {
        super.logging(
                "Sos was sent to patrul with passport: "
                        + this.getPatrulPassportSeries()
                        + " at: " + super.newDate()
                        + " with status: " + this.getStatus()
        );
    }
}
