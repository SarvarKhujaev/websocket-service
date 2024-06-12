package com.ssd.mvd.websocketservice.entity;

import java.util.UUID;

import com.ssd.mvd.websocketservice.constants.Topics;
import com.ssd.mvd.websocketservice.inspectors.LogInspector;
import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;

public final class TabletLocation extends LogInspector implements ObjectCommonMethods {
    public long getDate() {
        return this.date;
    }

    public UUID getPatrulUUID() {
        return this.patrulUUID;
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

    @Override
    public String getTopicName() {
        return Topics.TABLETS_GPS_DATA.getName();
    }

    @Override
    public void printMessage() {
        super.logging(
                "Tablet Location from: "
                        + this.getPatrulUUID()
                        + " at: "
                        + super.newDate( this.getDate() )
        );
    }
}
