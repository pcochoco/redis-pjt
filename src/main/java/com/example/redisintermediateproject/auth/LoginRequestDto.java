package com.example.redisintermediateproject.auth;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String account;
    private String password;
}
