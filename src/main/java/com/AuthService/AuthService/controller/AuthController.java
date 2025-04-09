package com.AuthService.AuthService.controller;


import com.AuthService.AuthService.entities.RefreshToken;
import com.AuthService.AuthService.models.UserInfoDto;
import com.AuthService.AuthService.response.JwtResponseDto;
import com.AuthService.AuthService.service.JwtService;
import com.AuthService.AuthService.service.RefreshTokenService;
import com.AuthService.AuthService.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("auth/v1/signup")
    public ResponseEntity signUp(@RequestBody UserInfoDto userInfoDto)  {
         try{
             Boolean isSignUp = userDetailsService.signupUser(userInfoDto);
             if(Boolean.FALSE.equals(isSignUp)){
                 return new ResponseEntity<>("Already exists", HttpStatus.BAD_REQUEST);
             }
             RefreshToken refreshToken = refreshTokenService.createRefreshToken(userInfoDto.getUsername());
             String jwtToken = jwtService.GenerateToken(userInfoDto.getUsername());
             return new ResponseEntity<>(JwtResponseDto.builder().accessToken(jwtToken).token(refreshToken.getToken()).build(), HttpStatus.OK);
         }catch (Exception e){
             return new ResponseEntity<>("Exception in User Service", HttpStatus.INTERNAL_SERVER_ERROR);

         }
    }
}
