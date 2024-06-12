package com.ssd.mvd.websocketservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.UUID;

@lombok.Data
@Jacksonized
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@JsonIgnoreProperties( ignoreUnknown = true )
public class SearchingPersonRedis {
    private UUID id;

    private Boolean beard;
    private Boolean state;
    private Boolean gender;
    private Boolean isForeigner; //chet ellik 1 xa 0 yoq

    private Date createdDate;
    private Date expirationDate;
    private Date dateOfRegistration;

    private Long toAge;
    private Long fromAge;
    private Long regionId;
    private Long orginalAge;
    private Long daysWithoutRegistration;

    private String file;
    private String name;
    private String photo;
    private String country;
    private String kppName;
    private String purpose;
    private String policeId;
    private String stateType;////QIDIRUVDA ANIQLANGAN
    private String routeType;
    private String visaNumber;
    private String definition;
    private String description;
    private String countryCode;
    private String documentNumber;
}
