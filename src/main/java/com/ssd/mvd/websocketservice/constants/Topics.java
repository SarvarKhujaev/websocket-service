package com.ssd.mvd.websocketservice.constants;

public enum Topics {
    REDIS_CAR {
        @Override
        public String getName () {
            return "/redisCar";
        }
    },
    SOS_TOPIC {
        @Override
        public String getName () {
            return "/sos_topic";
        }
    },
    PERSON_REDIS {
        @Override
        public String getName () {
            return "/personRedis";
        }
    },
    NEW_CAR_TOPIC {
        @Override
        public String getName () {
            return "/newCarTopic";
        }
    },
    NOTIFICATION {
        @Override
        public String getName () {
            return "/notification";
        }
    },
    CAR_TOTAL_DATA {
        @Override
        public String getName () {
            return "/car_total_data";
        }
    },
    TABLETS_GPS_DATA {
        @Override
        public String getName () {
            return "/tablets_gps_data";
        }
    },
    NEW_TUPLE_OF_CAR_TOPIC {
        @Override
        public String getName () {
            return "/newTupleOfCarTopic";
        }
    },
    EXTERNAL_TABLETS_GPS_DATA {
        @Override
        public String getName () {
            return "/tupleOfCarLocationTopic";
        }
    },
    WEBSOCKET_SERVICE_TOPIC_FOR_ONLINE {
        @Override
        public String getName () {
            return "/external_tablets_gps_data";
        }
    },
    TUPLE_OF_CAR_LOCATION_TOPIC {
        @Override
        public String getName () {
            return "/tupleOfCarLocationTopic";
        }
    },
    SOS_TOPIC_FOR_ANDROID_NOTIFICATION {
        @Override
        public String getName () {
            return "/webSocketServiceTopicForOnline";
        }
    };

    public String getName () {
        return "";
    }
}
