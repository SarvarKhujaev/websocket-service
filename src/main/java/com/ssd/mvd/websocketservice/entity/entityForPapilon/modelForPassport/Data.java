package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForPassport;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Data {
    private Person Person;
    private Document Document;
    private RequestGuid RequestGuid;
}
