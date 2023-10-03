package com.example.cgrmovies.model.response;
/**
 * This class handles the login response
 */
public class LoginResponse {

    public String jwt;

    public LoginResponse(String jwt) {
        this.jwt = jwt;
    }

}
