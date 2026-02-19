package com.clinic.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthDtos {
    public record LoginRequest(@Email String email, @NotBlank String password) {}
    public record RegisterPatientRequest(@NotBlank String fullName, @Email String email, @NotBlank String password) {}
    public record AuthResponse(String token, String role, Long userId, String fullName) {}
}
