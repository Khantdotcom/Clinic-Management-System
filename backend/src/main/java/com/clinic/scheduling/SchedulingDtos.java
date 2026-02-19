package com.clinic.scheduling;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SchedulingDtos {
    public record AvailabilityRequest(@NotNull @FutureOrPresent LocalDate date, @NotNull List<LocalTime> slots) {}
    public record AvailabilityResponse(Long doctorId, LocalDate date, List<LocalTime> slots) {}

    public record BookAppointmentRequest(@NotNull Long doctorId, @NotNull @FutureOrPresent LocalDate date, @NotNull LocalTime time) {}
    public record AppointmentResponse(Long id, Long doctorId, Long patientId, LocalDate date, LocalTime time, String status) {}
}
