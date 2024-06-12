package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.Status;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class SosNotificationForAndroid {
    private Status status;
    private Double latitude;
    private Double longitude;

    private Long regionId;
    private Long mahallaId;
    private Long districtId; // choosing from dictionary

    private String rank;
    private String address;
    private String dateOfBirth;
    private String phoneNumber;
    private String patrulImageLink;
    private String patrulPassportSeries;
    private String surnameNameFatherName; // Ф.И.О
}
