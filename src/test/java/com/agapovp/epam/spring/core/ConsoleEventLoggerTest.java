package com.agapovp.epam.spring.core;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@FieldDefaults(level = AccessLevel.PRIVATE)
class ConsoleEventLoggerTest {
    static final String TEST_STRING = "Test string.";

    @Test
    @DisplayName("Method logEvent works correctly.")
    void logEvent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Event event = (Event) context.getBean("event");
        String testString = TEST_STRING.trim();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream realOut = System.out;
        PrintStream testOut = new PrintStream(stream);

        event.setMessage(testString);
        System.setOut(testOut);
        new ConsoleEventLogger()
                .logEvent(event);
        System.setOut(realOut);
        assertEquals(event.toString(), stream.toString().trim());
    }
}