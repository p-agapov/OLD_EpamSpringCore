package com.agapovp.epam.spring.core;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
class ClientTest {
    static final String TEST_STRING_ID = "1";
    static final String TEST_STRING_FULL_NAME = "John Smith";
    static Client client = new Client(TEST_STRING_ID, TEST_STRING_FULL_NAME);

    @Test
    @DisplayName("id field getter works correctly.")
    void getId() {
        assertEquals(TEST_STRING_ID, client.getId());
    }

    @Test
    @DisplayName("fullName getter works correctly.")
    void getFullName() {
        assertEquals(TEST_STRING_FULL_NAME, client.getFullName());
    }

    @Test
    @DisplayName("id setter works correctly.")
    void setId() {
        String newId = "2";
        client.setId(newId);
        assertEquals(newId, client.getId());
        client.setId(TEST_STRING_ID);
    }

    @Test
    @DisplayName("fullName setter works correctly.")
    void setFullName() {
        String newFullName = "Joanna Smith";
        client.setFullName(newFullName);
        assertEquals(newFullName, client.getFullName());
        client.setFullName(TEST_STRING_FULL_NAME);
    }
}