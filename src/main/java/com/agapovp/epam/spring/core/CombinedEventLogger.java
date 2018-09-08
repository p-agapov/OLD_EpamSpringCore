package com.agapovp.epam.spring.core;

import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
public class CombinedEventLogger implements EventLogger {
    Collection<EventLogger> loggers;

    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
