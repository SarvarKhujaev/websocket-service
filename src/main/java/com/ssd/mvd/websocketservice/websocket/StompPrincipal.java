package com.ssd.mvd.websocketservice.websocket;

import java.security.Principal;

public final class StompPrincipal implements Principal {
    private String name;

    public StompPrincipal(
            final String name
    ) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
