package com.ssd.mvd.websocketservice.websocket;

import com.ssd.mvd.websocketservice.entity.entityForPapilon.CarTotalData;
import com.ssd.mvd.websocketservice.inspectors.WebFluxInspector;
import com.ssd.mvd.websocketservice.constants.Status;
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

    public MessageSendingService ( final SimpMessagingTemplate simpMessagingTemplate ) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public String sendMessage ( final ReqCar reqCar ) {
        super.convert( reqCar )
                .doOnError( super::logging )
                .subscribe( reqCar1 -> this.getSimpMessagingTemplate().convertAndSend( "/newCarTopic", reqCar1 ) );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final TupleOfCar tupleOfCar ) {
        super.convert( tupleOfCar )
                .doOnError( super::logging )
                .subscribe( tupleOfCar1 -> this.getSimpMessagingTemplate().convertAndSend( "/newTupleOfCarTopic", tupleOfCar1 ) );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final CarTotalData carTotalData ) {
        super.convert( carTotalData )
                .doOnError( super::logging )
                .subscribe( sosMessageForTopic1 -> {
                    super.logging( "CarTotalData: " + carTotalData.getCameraImage() + " was sent at: " + super.newDate() );
                    this.getSimpMessagingTemplate().convertAndSend( "/car_total_data", carTotalData );
                } );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final Notification notification1 ) {
        super.convert( notification1 )
                .doOnError( super::logging )
                .subscribe( notification -> {
                    super.logging( "Notification: " + notification.getStatus() + " : " + this.sendNotification( notification ) ); // sending to front

                    if ( notification.getStatus().compareTo( Status.ATTACHED ) == 0 ) {
                        super.logging( "Sending notification to: /notification/" + notification.getPassportSeries() );
                        notification.changeTitle();

                        super.logging( "Title: " + notification.getTitle() );

                        // sending to Android
                        this.getSimpMessagingTemplate().convertAndSend( "/notification/" + notification.getPassportSeries(), notification );
                    }
                } );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final TabletLocation tabletLocation ) {
        super.convert( tabletLocation )
                .doOnError( super::logging )
                .subscribe( locationExchange -> {
                    super.logging(
                            "Tablet Location from: "
                                    + locationExchange.getPatrulUUID()
                                    + " at: "
                                    + super.newDate( locationExchange.getDate() )
                    );

                    this.getSimpMessagingTemplate().convertAndSend( "/external_tablets_gps_data", tabletLocation );
                } );

        return Status.ACCEPTED.name();
    }

    private String sendNotification ( final Notification notification ) {
        super.convert( notification )
                .doOnError( super::logging )
                .filter( super::check )
                .subscribe( notification1 -> this.getSimpMessagingTemplate().convertAndSend( "/notification", notification1 ) );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final SosNotification sosNotification ) {
        super.convert( sosNotification )
                .doOnError( super::logging )
                .subscribe( sosNotification1 -> {
                    super.logging(
                            "Sos message from: " + sosNotification.getPatrulUUID()
                            + " was sent at: " + super.newDate()
                            + " with status: " + sosNotification.getStatus()
                    );

                    this.getSimpMessagingTemplate().convertAndSend( "/sos_topic", sosNotification );
                } );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final SearchingCarRedis searchingCarRedis ) {
        super.convert( searchingCarRedis )
                .doOnError( super::logging )
                .subscribe( carRedis -> {
                    super.logging( "Got SearchingCarRedis: " + searchingCarRedis );
                    this.getSimpMessagingTemplate().convertAndSend( "/redisCar", carRedis );
                } );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final Position position, final String topic ) {
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

    public String sendMessage ( final ReqLocationExchange reqLocationExchange ) {
        super.convert( reqLocationExchange )
                .doOnError( super::logging )
                .subscribe( locationExchange -> {
                    this.getSimpMessagingTemplate().convertAndSend( "/tablets_gps_data", reqLocationExchange );
                    this.getSimpMessagingTemplate().convertAndSend(
                            "/tablets_gps_data/" + reqLocationExchange.getRegionId(), reqLocationExchange
                    );

                    this.getSimpMessagingTemplate().convertAndSend(
                            "/tablets_gps_data/" +
                                    reqLocationExchange.getRegionId() + "/" +
                                    reqLocationExchange.getDistrictId(), reqLocationExchange
                    );

                    this.getSimpMessagingTemplate().convertAndSend(
                            "/tablets_gps_data/" +
                                    reqLocationExchange.getRegionId() + "/" +
                                    reqLocationExchange.getDistrictId() + "/" +
                                    reqLocationExchange.getMahallaId(), reqLocationExchange
                    );
                } );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final SearchingPersonRedis searchingPersonRedis ) {
        super.convert( searchingPersonRedis )
                .doOnError( super::logging )
                .subscribe( personRedis -> {
                    super.logging( "Got SearchingCarRedis: " + searchingPersonRedis.getId() );
                    this.getSimpMessagingTemplate().convertAndSend( "/personRedis", personRedis );
                } );

        return Status.ACCEPTED.name();
    }

    public String sendMessage ( final SosNotificationForAndroid sosNotificationForAndroid ) {
        super.convert( sosNotificationForAndroid )
                .doOnError( super::logging )
                .subscribe( sosNotificationForAndroid1 -> {
                    super.logging(
                            "Sos was sent to patrul with passport: "
                            + sosNotificationForAndroid.getPatrulPassportSeries()
                            + " at: " + super.newDate()
                            + " with status: " + sosNotificationForAndroid.getStatus()
                    );

                    this.getSimpMessagingTemplate().convertAndSend(
                            "/SOS_TOPIC_FOR_ANDROID_NOTIFICATION/"
                                    + sosNotificationForAndroid.getPatrulPassportSeries(),
                            sosNotificationForAndroid
                    );
                } );

        return Status.ACCEPTED.name();
    }
}