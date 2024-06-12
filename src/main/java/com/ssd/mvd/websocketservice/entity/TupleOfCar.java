package com.ssd.mvd.websocketservice.entity;

import java.util.UUID;

public final class TupleOfCar {
    private UUID uuid;
    private UUID uuidOfEscort; // UUID of the Escort which this car is linked to
    private UUID uuidOfPatrul; // UUID of the Escort which this car is linked to

    private String carModel;
    private String gosNumber;
    private String trackerId;
    private String nsfOfPatrul;
    private String simCardNumber;

    private double latitude;
    private double longitude;
    private double averageFuelConsumption;
}
