package com.clinic.clinical;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PrescriptionDtos {
    public record CreatePrescriptionRequest(@NotNull Long appointmentId, @NotBlank String diagnosis, @NotBlank String medications, String notes) {}
    public record PrescriptionResponse(Long id, Long appointmentId, Long doctorId, String diagnosis, String medications, String notes) {}
}
