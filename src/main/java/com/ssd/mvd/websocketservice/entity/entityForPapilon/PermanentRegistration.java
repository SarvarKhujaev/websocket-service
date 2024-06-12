package com.ssd.mvd.websocketservice.entity.entityForPapilon;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class PermanentRegistration {
    private String pAddress;
    private String pCadastre;
    private String pRegistrationDate;
    private com.ssd.mvd.websocketservice.entity.entityForPapilon.pRegion pRegion;
    private com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForAddress.pDistrict pDistrict;
}
