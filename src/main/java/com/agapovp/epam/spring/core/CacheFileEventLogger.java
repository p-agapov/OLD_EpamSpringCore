package com.agapovp.epam.spring.core;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            for (Event ev : cache) {
                super.logEvent(ev);
            }
            cache.clear();
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            for (Event ev : cache) {
                super.logEvent(ev);
            }
        }
    }
}
