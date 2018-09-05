package com.agapovp.epam.spring.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class App {
    Client client;
    EventLogger eventLogger;

    public static void main(String[] args) {
        App app = new App();

        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(
                client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
