package com.ssd.mvd.websocketservice.entity.entityForPapilon.modelForGai;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ssd.mvd.websocketservice.constants.ErrorResponse;
import java.util.List;

public final class DoverennostList {
    private ErrorResponse errorResponse;
    @JsonDeserialize
    private List< Doverennost > doverennostsList;
}
