package com.ssd.mvd.websocketservice.entity;

import java.util.UUID;

public final class TabletLocation {
    public UUID getPatrulUUID() {
        return this.patrulUUID;
    }

    public long getDate() {
        return this.date;
    }

    // all Patrul params
    private UUID patrulUUID;
    private String policeType;

    // original values from each Tablet
    private double latitude;
    private double longitude;

    private long date;
    private int speed; // скоросmь передвижения патрульного
    private int batteryLevel;
}
