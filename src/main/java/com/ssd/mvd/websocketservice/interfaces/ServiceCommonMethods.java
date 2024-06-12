package com.ssd.mvd.websocketservice.interfaces;

public interface ServiceCommonMethods {
    default void close( final Throwable throwable ) {}

    void close();
}
