package com.nc.todo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello";
    }

    @GetMapping("/private")
    public String helloPrivateWorld(@AuthenticationPrincipal OidcUser user){
        return "Hello to private section " +user.getFullName();
    }
}
