package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForGai;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class ViolationsInformation {
    private Integer decreeStatus;
    private Integer amount;

    private String decreeSerialNumber;
    private String violation;
    private String division;
    private String payDate;
    private String address;
    private String article;
    private String owner;
    private String model;
    private String bill;
}
