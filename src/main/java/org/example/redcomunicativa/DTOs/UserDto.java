package org.example.redcomunicativa.DTOs;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String role;
}
