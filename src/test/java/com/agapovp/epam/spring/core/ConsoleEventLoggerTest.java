package com.agapovp.epam.spring.core;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@FieldDefaults(level = AccessLevel.PRIVATE)
class ConsoleEventLoggerTest {
    static final String TEST_STRING = "Test string.";

    @Test
    @DisplayName("Method logEvent works correctly.")
    void logEvent() {
        String testString = TEST_STRING.trim();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream realOut = System.out;
        PrintStream testOut = new PrintStream(stream);

        System.setOut(testOut);
        new ConsoleEventLogger()
                .logEvent(testString);
        System.setOut(realOut);
        assertEquals(testString, stream.toString().trim());
    }
}