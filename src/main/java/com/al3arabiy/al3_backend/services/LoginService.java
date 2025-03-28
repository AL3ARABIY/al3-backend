package com.al3arabiy.al3_backend.services;

import com.al3arabiy.al3_backend.dto.CustomUserDetails;
import com.al3arabiy.al3_backend.dto.LoginRequest;
import com.al3arabiy.al3_backend.entities.User;
import com.al3arabiy.al3_backend.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final HttpServletRequest request;

    public String login(@Valid LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(customUserDetails);

        updateUserInfo(customUserDetails.user());

        return jwtToken;
    }

    private void updateUserInfo(User user) {
        user.setLastLoginDate(LocalDateTime.now());
        user.setLastLoginIp(request.getRemoteAddr());
        userRepository.save(user);
    }

}
