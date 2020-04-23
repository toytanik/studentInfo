package com.toytanik.ims.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserResponse {

    private String name;
    private String surname;
    private String email;
}
