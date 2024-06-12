package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;
import com.ssd.mvd.websocketservice.inspectors.LogInspector;
import com.ssd.mvd.websocketservice.constants.Topics;
import com.ssd.mvd.websocketservice.constants.Status;

import java.util.UUID;

public final class SosNotification extends LogInspector implements ObjectCommonMethods {
    private UUID patrulUUID;

    private Status status;

    public UUID getPatrulUUID() {
        return this.patrulUUID;
    }

    public Status getStatus() {
        return this.status;
    }

    @Override
    public String getTopicName() {
        return Topics.SOS_TOPIC.getName();
    }

    @Override
    public void printMessage() {
        super.logging(
                "Sos message from: " + this.getPatrulUUID()
                        + " was sent at: " + super.newDate()
                        + " with status: " + this.getStatus()
        );
    }
}
