package com.al3arabiy.al3_backend.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdateAccountRequest(
        String firstName,
        String lastName,
        @Email
        String email,
        @Past
        LocalDate birthDate,
        @NotEmpty @NotBlank @Size(min = 3, max = 32)
        String username,
        @NotEmpty @NotBlank
        String currentPassword
) {}
