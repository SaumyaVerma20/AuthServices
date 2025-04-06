package com.AuthService.AuthService.models;

import com.AuthService.AuthService.entities.Userinfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto extends Userinfo {
    private String userName;
    private String lastName;
    private Long phoneNumber;
    private String email;
}
