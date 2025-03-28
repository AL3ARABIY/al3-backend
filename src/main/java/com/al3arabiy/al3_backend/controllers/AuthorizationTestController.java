package com.al3arabiy.al3_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @Deprecated
@RequestMapping("/auth-test")
public class AuthorizationTestController {

    @GetMapping("/authentication-required")
    public String test() {
        return "Authorization test successful!";
    }

    @GetMapping("/authentication-not-required")
    public String testWithoutAuth() {
        return "Authorization test without authentication successful!";
    }
}
