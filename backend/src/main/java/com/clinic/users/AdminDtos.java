package com.clinic.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AdminDtos {
    public record DoctorUpsertRequest(@NotBlank String fullName, @Email String email, @NotBlank String password, @NotBlank String specialty) {}
    public record DoctorResponse(Long id, String fullName, String email, String specialty) {}
}
