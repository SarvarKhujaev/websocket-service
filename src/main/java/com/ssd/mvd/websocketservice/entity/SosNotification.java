package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.Status;
import java.util.UUID;

public final class SosNotification {
    private UUID patrulUUID;

    private Status status;

    public UUID getPatrulUUID() {
        return this.patrulUUID;
    }

    public Status getStatus() {
        return this.status;
    }
}
