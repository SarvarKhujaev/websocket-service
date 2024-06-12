package com.ssd.mvd.websocketservice.inspectors;

import reactor.core.publisher.Mono;

/*
хранит все функции для более компактного и удобного хранения всех основных функции WebFlux
*/
public class WebFluxInspector extends LogInspector {
    protected WebFluxInspector() {}

    protected final synchronized <T> Mono<T> convert (
            final T object
    ) {
        return Mono.just( object );
    }
}
