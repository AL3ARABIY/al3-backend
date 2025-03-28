package com.al3arabiy.al3_backend.services;

import com.al3arabiy.al3_backend.entities.User;
import com.al3arabiy.al3_backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrentAuthenticatedUser {

    private final UserRepository userRepository;

    public Optional<User> retrieve() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() ) return Optional.empty();
        return userRepository.findByUsername(authentication.getName());
    }

}
