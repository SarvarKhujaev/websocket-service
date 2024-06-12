package com.ssd.mvd.websocketservice.inspectors;

import com.ssd.mvd.websocketservice.WebSocketServiceApplication;
import com.ssd.mvd.websocketservice.entity.Notification;
import com.ssd.mvd.websocketservice.constants.Status;

public class DataValidateInspector extends TimeInspector {
    protected DataValidateInspector () {}

    protected final synchronized boolean objectIsNotNull (
            final Object o
    ) {
        return o != null;
    }

    protected final synchronized boolean check (
            final Notification notification
    ) {
        return notification.getStatus().compareTo( Status.ATTACHED ) != 0
                && notification.getStatus().compareTo( Status.CANCEL ) != 0;
    }

    /*
    получает в параметрах название параметра из файла application.yaml
    проверят что context внутри main класса GpsTabletsServiceApplication  инициализирован
    и среди параметров сервиса сузествует переданный параметр
    */
    protected final synchronized <T> T checkContextOrReturnDefaultValue (
            final String paramName,
            final T defaultValue
    ) {
        return this.objectIsNotNull( WebSocketServiceApplication.context )
                && this.objectIsNotNull(
                        WebSocketServiceApplication
                                .context
                                .getEnvironment()
                                .getProperty( paramName )
                )
                ? (T) WebSocketServiceApplication
                .context
                .getEnvironment()
                .getProperty( paramName )
                : defaultValue;
    }
}
