package com.clinic.scheduling;

import com.clinic.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final SchedulingService schedulingService;

    public DoctorController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @GetMapping("/{id}/availability")
    public ApiResponse<SchedulingDtos.AvailabilityResponse> getAvailability(@PathVariable Long id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ApiResponse.ok("Availability fetched", schedulingService.getAvailability(id, date));
    }

    @PutMapping("/{id}/availability")
    public ApiResponse<SchedulingDtos.AvailabilityResponse> setAvailability(@PathVariable Long id, @Valid @RequestBody SchedulingDtos.AvailabilityRequest request) {
        return ApiResponse.ok("Availability updated", schedulingService.setAvailability(id, request));
    }

    @GetMapping("/{id}/appointments")
    public ApiResponse<List<SchedulingDtos.AppointmentResponse>> doctorAppointments(@PathVariable Long id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ApiResponse.ok("Appointments fetched", schedulingService.doctorAppointments(id, date));
    }
}
