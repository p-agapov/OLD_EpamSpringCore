package com.agapovp.epam.spring.core;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Client {
    String id;
    String fullName;
}
