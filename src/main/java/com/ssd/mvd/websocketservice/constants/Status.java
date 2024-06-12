package com.ssd.mvd.websocketservice.constants;

public enum Status {
    LOGIN, LOGOUT,
    START_TO_WORK, STOP_TO_WORK,
    SET_IN_PAUSE, RETURNED_TO_WORK,

    AVAILABLE, NOT_AVAILABLE,
    CREATED, IN_GARAGE, CANCEL,
    ACCEPTED, LATE, NOT_ARRIVED, IN_TIME,
    FREE, ARRIVED, BUSY,
    ATTACHED {
        @Override
        public boolean isAttached () {
            return true;
        }
    },
    FINISHED,

    SELF_EMPLOYMENT, NOTIFICATION, ACTIVE_TASK, NEW_CARS,

    ACTIVE, IN_ACTIVE;

    public boolean isAttached () {
        return false;
    }
}
