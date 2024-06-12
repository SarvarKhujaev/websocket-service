package com.ssd.mvd.websocketservice.websocket;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ssd.mvd.websocketservice.constants.Topics;
import com.ssd.mvd.websocketservice.inspectors.CollectionsInspector;

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
public class WebSocketConfig extends CollectionsInspector implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(
            final MessageBrokerRegistry config
    ) {
        super.analyze(
                super.convertArrayToList( Topics.values() ),
                topics -> config.enableSimpleBroker( topics.getName() )
        );

        config.setApplicationDestinationPrefixes( "/app" );
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
