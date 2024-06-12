package com.ssd.mvd.websocketservice.entity;

import java.util.UUID;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public final class TabletLocation {
    // all Patrul params
    private UUID patrulUUID;
    private String policeType;

    // original values from each Tablet
    private Double latitude;
    private Double longitude;

    private Long date;
    private Integer speed; // скоросmь передвижения патрульного
    private Integer batteryLevel;
}
