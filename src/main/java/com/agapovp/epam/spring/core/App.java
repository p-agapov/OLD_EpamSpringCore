package com.agapovp.epam.spring.core;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class App {
    Client client;
    EventLogger eventLogger;
    Map<EventType, EventLogger> loggers;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");

        app.logEvent(null, "Some event for user 1");
        app.logEvent(EventType.INFO,"Some event for user 2");
        app.logEvent(EventType.ERROR,"Some event for user 3");

        context.close();
    }

    private void logEvent(EventType type, String msg) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Event event = (Event) context.getBean("event");

        String message = msg.replaceAll(
                client.getId(), client.getFullName());
        event.setMessage(message);

        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = eventLogger;
        }
        logger.logEvent(event);
    }
}
