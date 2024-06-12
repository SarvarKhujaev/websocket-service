package com.ssd.mvd.websocketservice.inspectors;

import java.util.function.Consumer;
import java.util.Collection;

public class CollectionsInspector extends LogInspector {
    protected CollectionsInspector() {}

    /*
    получает коллекцию и логику описывающую поведение для элементов коллекции
    */
    protected final synchronized <T> void analyze (
            final Collection<T> someList,
            final Consumer<T> someConsumer
    ) {
        someList.forEach( someConsumer );
    }
}
