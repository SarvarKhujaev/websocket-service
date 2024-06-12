package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForPassport;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Document {
    private String IssuedBy;
    private String DateIssue;
    private String SerialNumber;
    private DocumentType DocumentType;
}
