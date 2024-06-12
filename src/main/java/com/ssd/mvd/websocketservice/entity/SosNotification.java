package com.ssd.mvd.websocketservice.entity;

import com.ssd.mvd.websocketservice.constants.Status;
import java.util.UUID;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class SosNotification {
    private UUID patrulUUID;
    private Status status;
}
