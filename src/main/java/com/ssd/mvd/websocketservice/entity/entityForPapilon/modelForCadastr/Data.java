package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForCadastr;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

public final class Data {
    @JsonDeserialize
    private List< Person > PermanentRegistration;
    @JsonDeserialize
    private List< TemproaryRegistration > TemproaryRegistration;
}
