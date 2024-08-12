package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String username;
    private String password;
    private String role;
    private String photo;
    private String description;
}
