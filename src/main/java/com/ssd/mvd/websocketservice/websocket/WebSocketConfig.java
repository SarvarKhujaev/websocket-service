package com.ssd.mvd.websocketservice.websocket;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.util.MimeTypeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(
            final MessageBrokerRegistry config
    ) {
        config.enableSimpleBroker(
                "/redisCar",
                "/sos_topic",
                "/personRedis",
                "/newCarTopic",
                "/notification",
                "/car_total_data",
                "/tablets_gps_data",
                "/newTupleOfCarTopic",
                "/tupleOfCarLocationTopic",
                "/external_tablets_gps_data",
                "/webSocketServiceTopicForOnline",
                "/SOS_TOPIC_FOR_ANDROID_NOTIFICATION"
        );

        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints( StompEndpointRegistry registry ) {
        registry.addEndpoint("/websocket").setAllowedOriginPatterns("*").withSockJS();
        registry.addEndpoint("/ws").setAllowedOrigins("*").setHandshakeHandler( new CustomHandshakeHandler() );
        registry.addEndpoint("/ws").setAllowedOrigins("*").setHandshakeHandler( new CustomHandshakeHandler() ).withSockJS();
    }

    @Override
    public boolean configureMessageConverters( List<MessageConverter> messageConverters ) {
        final DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
        resolver.setDefaultMimeType( MimeTypeUtils.APPLICATION_JSON );

        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper( new ObjectMapper() );
        converter.setContentTypeResolver( resolver );
        messageConverters.add( converter );

        return false;
    }
}
