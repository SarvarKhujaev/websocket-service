package com.ssd.mvd.websocketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ssd.mvd.websocketservice.kafka.KafkaDataControl;

@SpringBootApplication
public class WebSocketServiceApplication {
    public static ApplicationContext context;

    public static void main( String[] args ) {
        context = SpringApplication.run( WebSocketServiceApplication.class, args );
        new KafkaDataControl();
    }
}
