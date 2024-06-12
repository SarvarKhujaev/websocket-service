package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.TaskTypes;
import com.ssd.mvd.websocketservice.constants.Status;
import java.util.UUID;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class ReqLocationExchange {
    // all Patrul params
    private Status status;
    private UUID patrulUUID;
    private Boolean sosStatus; // показывает послал ли патрульный сос сигнал
    private TaskTypes taskTypes;

    private String card;
    private String icon;
    private String icon2;
    private String patrulName;
    private String policeType;
    private String patrulPassportSeries;

    private Double latitudeOfTask;
    private Double longitudeOfTask;

    private Long regionId;
    private Long mahallaId;
    private Long districtId; // choosing from dictionary

    // original values from each Tablet
    private Double longitude;
    private Double latitude;

    private Long date;
    private Integer speed; // скорось передвижения патрулього
    private Integer batteryLevel;
}
