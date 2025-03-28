package com.al3arabiy.al3_backend.controllers;

import com.al3arabiy.al3_backend.dto.RegistrationRequest;
import com.al3arabiy.al3_backend.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody RegistrationRequest registrationRequest) {
        registrationService.register(registrationRequest);
    }

}
