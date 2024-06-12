package com.ssd.mvd.websocketservice.inspectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogInspector extends DataValidateInspector {
    private final Logger LOGGER = LogManager.getLogger( "LOGGER_WITH_JSON_LAYOUT" );

    public Logger getLOGGER() {
        return this.LOGGER;
    }

    protected final synchronized void logging ( String message ) {
        this.getLOGGER().info( message );
    }

    protected final synchronized void logging ( Throwable error ) {
        this.getLOGGER().error( "Error: " + error.getMessage() );
    }

    protected final synchronized void logging ( final Class<?> clazz ) {
        this.getLOGGER().info( clazz.getName() + " was created at: " + super.newDate() );
    }

    protected final synchronized void logging ( final Object o ) {
        this.getLOGGER().info( o.getClass().getName() + " was closed successfully at: " + super.newDate() );
    }
}
