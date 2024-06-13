package com.foodappbackend.foodapp.security.dto;

import com.foodappbackend.foodapp.enums.RolEnum;
import lombok.Data;

import java.util.Set;

@Data
public class RegistroRequest {
    private String username;
    private String password;
    private Set<RolEnum> roles;
}
