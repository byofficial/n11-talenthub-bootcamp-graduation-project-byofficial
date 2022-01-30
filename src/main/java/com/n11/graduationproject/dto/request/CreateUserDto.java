package com.n11.graduationproject.dto.request;

import lombok.Data;

@Data
public class CreateUserDto {
    private String username;
    private String password;
}