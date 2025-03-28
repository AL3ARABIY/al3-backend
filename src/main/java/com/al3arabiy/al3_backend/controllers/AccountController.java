package com.al3arabiy.al3_backend.controllers;

import com.al3arabiy.al3_backend.dto.UpdateAccountRequest;
import com.al3arabiy.al3_backend.services.UpdateAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final UpdateAccountService updateAccountService;

    @PostMapping("/update")
    public String updateAccount(@RequestBody UpdateAccountRequest updateAccountRequest) {
       return updateAccountService.updateAccount(updateAccountRequest);
    }

}
