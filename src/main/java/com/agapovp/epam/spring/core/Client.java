package com.agapovp.epam.spring.core;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
class Client {
    String id;
    String fullName;
    String greeting;

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
