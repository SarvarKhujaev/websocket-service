package com.ssd.mvd.websocketservice.entity;

import lombok.extern.jackson.Jacksonized;
import java.util.Date;
import java.util.UUID;

@lombok.Data
@Jacksonized
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class SearchingCarRedis {
    private UUID id;
    private Long regionId;
    private Date createdDate;

    private Boolean state;
    private Boolean person;

    private String name;
    private String file;
    private String color;
    private String photo;
    private String carType;
    private String policeId;
    private String stateCar;
    private String stateType;////QIDIRUVDA ANIQLANGAN
    private String carNumber;
    private String definition;
    private String personType;
    private String description;
}

