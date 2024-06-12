package com.ssd.mvd.websocketservice.websocket;

import com.ssd.mvd.websocketservice.interfaces.ObjectCommonMethods;
import com.ssd.mvd.websocketservice.subscribers.CustomSubscriber;
import com.ssd.mvd.websocketservice.inspectors.WebFluxInspector;
import com.ssd.mvd.websocketservice.constants.Status;
import com.ssd.mvd.websocketservice.constants.Topics;
import com.ssd.mvd.websocketservice.entity.*;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class MessageSendingService extends WebFluxInspector {
    @Autowired
    private final SimpMessagingTemplate simpMessagingTemplate;

    private SimpMessagingTemplate getSimpMessagingTemplate() {
        return this.simpMessagingTemplate;
    }

    public MessageSendingService (
            final SimpMessagingTemplate simpMessagingTemplate
    ) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    private void sendNotification (
            final Notification notification
    ) {
        super.convert( notification )
                .doOnError( super::logging )
                .filter( super::check )
                .subscribe(
                        new CustomSubscriber<>(
                                notification1 -> this.getSimpMessagingTemplate().convertAndSend(
                                        Topics.NOTIFICATION.getName(), notification1
                                )
                        )
                );
    }

    public String sendMessage (
            final ObjectCommonMethods objectCommonMethods
    ) {
        if ( objectCommonMethods instanceof Notification ) {
            this.sendNotification( (Notification) objectCommonMethods ); // sending to front
        }

        super.convert( objectCommonMethods )
                .doOnError( super::logging )
                .subscribe(
                        new CustomSubscriber<>(
                                objectCommonMethods1 -> {
                                    objectCommonMethods1.printMessage();
                                    this.getSimpMessagingTemplate().convertAndSend(
                                            objectCommonMethods1.getTopicName(), objectCommonMethods1
                                    );
                                }
                        )
                );

        return Status.ACCEPTED.name();
    }

    public String sendMessage (
            final Position position,
            final String topic
    ) {
        super.convert( position )
                .doOnError( super::logging )
                .subscribe( position1 -> {
                    this.getSimpMessagingTemplate().convertAndSend( "/" + topic, position1 );

                    this.getSimpMessagingTemplate().convertAndSend(
                            "/" + topic + "/" + position.getRegionId(),
                            position1
                    );

                    this.getSimpMessagingTemplate().convertAndSend(
                            "/" + topic + "/"
                            + position.getRegionId() + "/"
                            + position.getDistrictId(),
                            position1
                    );

                    this.getSimpMessagingTemplate().convertAndSend(
                            "/" + topic + "/"
                                    + position.getRegionId() + "/"
                                    + position.getDistrictId() + "/"
                                    + position.getMahallaId(),
                            position1
                    );
                } );

        return Status.ACCEPTED.name();
    }

    public String sendMessage (
            final ReqLocationExchange reqLocationExchange
    ) {
        super.convert( reqLocationExchange )
                .doOnError( super::logging )
                .subscribe( locationExchange -> {
                    this.getSimpMessagingTemplate().convertAndSend( Topics.TABLETS_GPS_DATA.getName(), reqLocationExchange );
                    this.getSimpMessagingTemplate().convertAndSend(
                            Topics.TABLETS_GPS_DATA.getName() + "/" + reqLocationExchange.getRegionId(),
                            reqLocationExchange
                    );

                    this.getSimpMessagingTemplate().convertAndSend(
                            Topics.TABLETS_GPS_DATA.getName() + "/" +
                                    reqLocationExchange.getRegionId() + "/" +
                                    reqLocationExchange.getDistrictId(),
                            reqLocationExchange
                    );

                    this.getSimpMessagingTemplate().convertAndSend(
                            Topics.TABLETS_GPS_DATA.getName() + "/" +
                                    reqLocationExchange.getRegionId() + "/" +
                                    reqLocationExchange.getDistrictId() + "/" +
                                    reqLocationExchange.getMahallaId(),
                            reqLocationExchange
                    );
                } );

        return Status.ACCEPTED.name();
    }
}