package com.ndmsk.websitebackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginRequest {
    private String email;
    private String password;
}
