package com.ssd.mvd.websocketservice.entity;

import java.util.Date;
import java.util.UUID;

public final class SearchingPersonRedis {
    public UUID getId() {
        return this.id;
    }

    private UUID id;

    private boolean beard;
    private boolean state;
    private boolean gender;
    private boolean isForeigner;

    private Date createdDate;
    private Date expirationDate;
    private Date dateOfRegistration;

    private long toAge;
    private long fromAge;
    private long regionId;
    private long orginalAge;
    private long daysWithoutRegistration;

    private String file;
    private String name;
    private String photo;
    private String country;
    private String kppName;
    private String purpose;
    private String policeId;
    private String stateType;
    private String routeType;
    private String visaNumber;
    private String definition;
    private String description;
    private String countryCode;
    private String documentNumber;
}
