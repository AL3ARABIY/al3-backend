package com.al3arabiy.al3_backend.controllers;

import com.al3arabiy.al3_backend.dto.LoginRequest;
import com.al3arabiy.al3_backend.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }

}
