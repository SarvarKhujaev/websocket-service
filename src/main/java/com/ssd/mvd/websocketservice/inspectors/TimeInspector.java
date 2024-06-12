package com.ssd.mvd.websocketservice.inspectors;

import java.util.Date;

public class TimeInspector {
    protected TimeInspector() {}

    protected final synchronized Date newDate () {
        return new Date();
    }

    protected final synchronized Date newDate (
            final long value
    ) {
        return new Date( value );
    }
}
