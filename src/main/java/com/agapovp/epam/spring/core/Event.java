package com.agapovp.epam.spring.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.text.DateFormat;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    static int count = 0;

    int id;
    @Setter
    @Getter
    String message;
    Date date;
    @Getter
    DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.id = ++count;
        this.message = "";
        this.date = date;
        this.dateFormat = dateFormat;

    }

    @Override
    public String toString() {
        return String.format("#%d: %s : %s", id, date, message);
    }
}
