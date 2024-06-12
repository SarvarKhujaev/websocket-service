package com.ssd.mvd.websocketservice.kafka;

import com.ssd.mvd.websocketservice.entity.entityForPapilon.CarTotalData;
import com.ssd.mvd.websocketservice.inspectors.CollectionsInspector;
import com.ssd.mvd.websocketservice.interfaces.ServiceCommonMethods;
import com.ssd.mvd.websocketservice.websocket.MessageSendingService;
import com.ssd.mvd.websocketservice.WebSocketServiceApplication;
import com.ssd.mvd.websocketservice.constants.Errors;
import com.ssd.mvd.websocketservice.entity.*;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.common.serialization.Serdes;

import org.springframework.kafka.config.TopicBuilder;
import org.apache.kafka.clients.admin.AdminClient;
import com.google.gson.Gson;

import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.KafkaStreams;

import java.util.function.Supplier;
import java.util.Collections;
import java.util.Properties;
import java.util.List;

public final class KafkaDataControl extends CollectionsInspector implements ServiceCommonMethods {
    private final Gson gson = new Gson();
    private final Properties properties = new Properties();
    private final MessageSendingService messageSendingService = WebSocketServiceApplication
            .context
            .getBean( MessageSendingService.class );
    private final AdminClient client = KafkaAdminClient.create( this.setProperties.get() );

    private final String KAFKA_BROKER = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_BROKER",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String GROUP_ID_FOR_KAFKA = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.GROUP_ID_FOR_KAFKA",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String NEW_TUPLE_OF_CAR_TOPIC = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.NEW_TUPLE_OF_CAR_TOPIC",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String TUPLE_OF_CAR_LOCATION_TOPIC = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.TUPLE_OF_CAR_LOCATION_TOPIC",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String NEW_CAR_TOPIC = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.NEW_CAR_TOPIC",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String WEBSOCKET_SERVICE_TOPIC_FOR_ONLINE = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.WEBSOCKET_SERVICE_TOPIC_FOR_ONLINE",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String EXTERNAL_TABLETS_LOCATIONS = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.EXTERNAL_TABLETS_LOCATIONS",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String REDIS_CAR = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.REDIS_CAR",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String REDIS_PERSON = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.REDIS_PERSON",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String TABLETS_GPS_DATA = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.TABLETS_GPS_DATA",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String NOTIFICATION = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.NOTIFICATION",
            Errors.DATA_NOT_FOUND.name()
    );

    // notification for front
    private final String SOS_TOPIC = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.SOS_TOPIC",
            Errors.DATA_NOT_FOUND.name()
    );

    // notification for android
    private final String SOS_TOPIC_FOR_ANDROID_NOTIFICATION = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.SOS_TOPIC_FOR_ANDROID_NOTIFICATION",
            Errors.DATA_NOT_FOUND.name()
    );

    private final String CAR_TOTAL_DATA = super.checkContextOrReturnDefaultValue(
            "variables.KAFKA_VARIABLES.KAFKA_TOPICS.CAR_TOTAL_DATA",
            Errors.DATA_NOT_FOUND.name()
    );

    private KafkaStreams kafkaStreams;
    private final StreamsBuilder builder = new StreamsBuilder();

    private final Supplier< Properties > setStreamProperties = () -> {
        this.properties.clear();
        this.properties.put( StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, this.KAFKA_BROKER );
        this.properties.put( StreamsConfig.APPLICATION_ID_CONFIG, this.GROUP_ID_FOR_KAFKA );
        this.properties.put( StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName() );
        this.properties.put( StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName() );
        return this.properties;
    };

    private final Supplier< Properties > setProperties = () -> {
            this.properties.clear();
            this.properties.put( AdminClientConfig.CLIENT_ID_CONFIG, this.GROUP_ID_FOR_KAFKA );
            this.properties.put( AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, this.KAFKA_BROKER );
            return this.properties;
    };

    private void createAllTopics () {
        super.analyze(
                List.of(
                        this.SOS_TOPIC_FOR_ANDROID_NOTIFICATION,
                        this.WEBSOCKET_SERVICE_TOPIC_FOR_ONLINE,
                        this.TUPLE_OF_CAR_LOCATION_TOPIC,
                        this.EXTERNAL_TABLETS_LOCATIONS,
                        this.NEW_TUPLE_OF_CAR_TOPIC,
                        this.TABLETS_GPS_DATA,
                        this.CAR_TOTAL_DATA,
                        this.NEW_CAR_TOPIC,
                        this.NOTIFICATION,
                        this.REDIS_PERSON,
                        this.REDIS_CAR,
                        this.SOS_TOPIC
                ),
                topic -> this.client.createTopics(
                        Collections.singletonList(
                                TopicBuilder
                                        .name( topic )
                                        .partitions( 5 )
                                        .replicas( 3 )
                                        .build()
                        )
                )
        );
    }

    public KafkaDataControl () {
        super.logging( "KafkaDataControl was created" );
        this.createAllTopics();
        this.start();
    }

    private void start () {
        final KStream< String, String > kStreamForGpsTablets = this.builder.stream(
                this.TABLETS_GPS_DATA, Consumed.with( Serdes.String(), Serdes.String() )
        );

        kStreamForGpsTablets
                .mapValues( value -> this.gson.fromJson( value, ReqLocationExchange.class ) )
                .mapValues( reqLocationExchange -> this.messageSendingService.sendMessage( reqLocationExchange ) );

        final KStream< String, String > kStreamForExternalTablets = this.builder.stream(
                this.EXTERNAL_TABLETS_LOCATIONS, Consumed.with( Serdes.String(), Serdes.String() )
        );

        kStreamForExternalTablets
                .mapValues( value -> this.gson.fromJson( value, TabletLocation.class ) )
                .mapValues( tabletLocation -> this.messageSendingService.sendMessage( tabletLocation ) );

        final KStream< String, String > kStreamForCarTotalData = this.builder.stream(
                this.CAR_TOTAL_DATA, Consumed.with( Serdes.String(), Serdes.String() )
        );

        kStreamForCarTotalData
                .mapValues( value -> this.gson.fromJson( value, CarTotalData.class ) )
                .mapValues( reqLocationExchange -> this.messageSendingService.sendMessage( reqLocationExchange ) );

        final KStream< String, String > kStreamForNotification = this.builder.stream(
                this.NOTIFICATION, Consumed.with( Serdes.String(), Serdes.String() )
        );

        kStreamForNotification
                .mapValues( value -> this.gson.fromJson( value, Notification.class ) )
                .mapValues( notification -> this.messageSendingService.sendMessage( notification ) );

        final KStream< String, String > kStreamForTupleCarLocation = this.builder.stream(
                this.TUPLE_OF_CAR_LOCATION_TOPIC, Consumed.with( Serdes.String(), Serdes.String() )
        );

        kStreamForTupleCarLocation
                .mapValues( value -> this.gson.fromJson( value, Position.class ) )
                .mapValues( position -> this.messageSendingService.sendMessage( position, "tupleOfCarLocationTopic" ) );

        final KStream< String, String > newTupleOfCarTopic = this.builder.stream(
                this.NEW_TUPLE_OF_CAR_TOPIC, Consumed.with( Serdes.String(), Serdes.String() )
        );

        newTupleOfCarTopic
                .mapValues( value -> this.gson.fromJson( value, TupleOfCar.class ) )
                .mapValues( tupleOfCar -> this.messageSendingService.sendMessage( tupleOfCar ) );

        final KStream< String, String > kStreamForPerson = this.builder.stream(
                this.REDIS_PERSON, Consumed.with( Serdes.String(), Serdes.String() )
        );

        kStreamForPerson
                .mapValues( value -> this.gson.fromJson( value, SearchingPersonRedis.class ) )
                .mapValues( searchingPersonRedis -> this.messageSendingService.sendMessage( searchingPersonRedis ) );

        final KStream< String, String > kStream = this.builder.stream( this.WEBSOCKET_SERVICE_TOPIC_FOR_ONLINE,
                Consumed.with( Serdes.String(), Serdes.String() )
        );

        kStream
                .mapValues( value -> this.gson.fromJson( value, Position.class ) )
                .mapValues( position -> this.messageSendingService.sendMessage( position, "webSocketServiceTopicForOnline" ) );

        final KStream< String, String > kStreamForCar = this.builder.stream(
                this.REDIS_CAR, Consumed.with( Serdes.String(), Serdes.String() )
        );

        kStreamForCar
                .mapValues( value -> this.gson.fromJson( value, SearchingCarRedis.class ) )
                .mapValues( searchingCarRedis -> this.messageSendingService.sendMessage( searchingCarRedis ) );

        final KStream< String, String > newCarTopic = this.builder.stream(
                this.NEW_CAR_TOPIC, Consumed.with( Serdes.String(), Serdes.String() )
        );

        newCarTopic
                .mapValues( value -> this.gson.fromJson( value, ReqCar.class ) )
                .mapValues( reqCar -> this.messageSendingService.sendMessage( reqCar ) );

        final KStream< String, String > sos_topic = this.builder.stream(
                this.SOS_TOPIC, Consumed.with( Serdes.String(), Serdes.String() )
        );

        sos_topic
                .mapValues( value -> this.gson.fromJson( value, SosNotification.class ) )
                .mapValues( sosNotification -> this.messageSendingService.sendMessage( sosNotification ) );

        final KStream< String, String > sos_topic_for_android = this.builder.stream(
                this.SOS_TOPIC_FOR_ANDROID_NOTIFICATION, Consumed.with( Serdes.String(), Serdes.String() )
        );

        sos_topic_for_android
                .mapValues( value -> this.gson.fromJson( value, SosNotificationForAndroid.class ) )
                .mapValues( sosNotificationForAndroid -> this.messageSendingService.sendMessage( sosNotificationForAndroid ) );

        this.kafkaStreams = new KafkaStreams( this.builder.build(), this.setStreamProperties.get() );
        this.kafkaStreams.start();
    }

    @Override
    public void close() {
        this.kafkaStreams.close();
        super.logging( this );
    }
}
