package com.ssd.mvd.websocketservice.entity.entityForPapilon;

import com.ssd.mvd.websocketservice.constants.ErrorResponse;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class Pinpp {
    private String Data;
    private String Name;
    private String Pinpp;
    private String Region;
    private String Surname;
    private String Country;
    private String Address;
    private String District;
    private String Patronym;
    private String Cadastre;
    private String BirthDate;

    private ErrorResponse errorResponse;
}
