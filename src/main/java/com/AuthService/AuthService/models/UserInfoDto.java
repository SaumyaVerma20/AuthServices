package com.AuthService.AuthService.models;

import com.AuthService.AuthService.entities.UserInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto extends UserInfo {
    //private String username;
    private String firstName; // first_name

    private String lastName; //last_name

    private Long phoneNumber;

    private String email; // email

}
