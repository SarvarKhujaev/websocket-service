package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.Status;

public final class SosNotificationForAndroid {
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
}
