package com.al3arabiy.al3_backend.services.auth;

import com.al3arabiy.al3_backend.dto.RegistrationRequest;
import com.al3arabiy.al3_backend.entities.User;
import com.al3arabiy.al3_backend.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service @Validated
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    public void register(@Valid RegistrationRequest registrationRequest) {

        if(!registrationRequest.password().equals(registrationRequest.confirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        if(userRepository.findByUsername(registrationRequest.username()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User();
        user.setUsername(registrationRequest.username());
        user.setPassword(registrationRequest.password());

        userRepository.save(user);

    }

}
