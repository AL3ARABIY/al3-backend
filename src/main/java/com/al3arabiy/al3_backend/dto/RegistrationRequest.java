package com.al3arabiy.al3_backend.dto;

import jakarta.validation.constraints.*;

public record RegistrationRequest(
        @NotEmpty @NotBlank @Size(min = 3, max = 32)
        String username,
        @NotEmpty @NotBlank @Size(min = 8, max = 32)
        String password,
        @NotEmpty @NotBlank @Size(min = 8, max = 32)
        String confirmPassword)
{}
