package com.al3arabiy.al3_backend.services;

import com.al3arabiy.al3_backend.dto.LoginRequest;
import com.al3arabiy.al3_backend.dto.UpdateAccountRequest;
import com.al3arabiy.al3_backend.exceptions.ValidationException;
import com.al3arabiy.al3_backend.repositories.UserRepository;
import com.al3arabiy.al3_backend.services.auth.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service @Validated @Slf4j
@RequiredArgsConstructor
public class UpdateAccountService {

    private final UserRepository userRepository;
    private final CurrentAuthenticatedUser currentAuthenticatedUser;
    private final PasswordEncoder passwordEncoder;
    private final LoginService loginService;

    public String updateAccount(@Valid UpdateAccountRequest updateAccountRequest) {

        currentAuthenticatedUser.retrieve()
                .ifPresentOrElse(user -> {

                    if(!passwordEncoder.matches(updateAccountRequest.currentPassword(), user.getPassword())) {
                        throw new ValidationException("Current password is incorrect");
                    }

                    if(!updateAccountRequest.username().equals(user.getUsername()) &&
                            userRepository.findByUsername(updateAccountRequest.username()).isPresent()) {
                        throw new ValidationException("Username already exists");
                    }

                    if(updateAccountRequest.email() != null && !updateAccountRequest.email().equals(user.getEmail()) &&
                            userRepository.findByEmail(updateAccountRequest.email()).isPresent()) {
                        throw new ValidationException("Email already exists");
                    }

                    user.setUsername(updateAccountRequest.username());
                    user.setEmail(updateAccountRequest.email());
                    user.setFirstName(updateAccountRequest.firstName());
                    user.setLastName(updateAccountRequest.lastName());
                    user.setBirthDate(updateAccountRequest.birthDate());
                    userRepository.save(user);

                }, () -> {
                    log.error("User not found or not authenticated");
                    throw new RuntimeException("User not found or not authenticated");
                });

        // Re-login the user to refresh the JWT token
        return loginService.login(new LoginRequest(
                updateAccountRequest.username(),
                updateAccountRequest.currentPassword()
        ));

    }

}
