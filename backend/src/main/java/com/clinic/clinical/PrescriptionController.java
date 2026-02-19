package com.clinic.clinical;

import com.clinic.common.ApiResponse;
import com.clinic.users.entity.User;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping("/prescriptions")
    public ApiResponse<PrescriptionDtos.PrescriptionResponse> create(@AuthenticationPrincipal User doctor,
                                                                     @Valid @RequestBody PrescriptionDtos.CreatePrescriptionRequest request) {
        return ApiResponse.ok("Prescription created", prescriptionService.create(doctor, request));
    }

    @GetMapping("/appointments/{id}/prescriptions")
    public ApiResponse<List<PrescriptionDtos.PrescriptionResponse>> appointmentPrescriptions(@AuthenticationPrincipal User user, @PathVariable Long id) {
        return ApiResponse.ok("Prescriptions fetched", prescriptionService.byAppointment(user, id));
    }

    @GetMapping("/patients/me/prescriptions")
    public ApiResponse<List<PrescriptionDtos.PrescriptionResponse>> myPrescriptions(@AuthenticationPrincipal User user) {
        return ApiResponse.ok("Use /appointments/{id}/prescriptions for per appointment retrieval", List.of());
    }
}
