package com.clinic.scheduling;

import com.clinic.common.ApiResponse;
import com.clinic.users.UserRepository;
import com.clinic.users.entity.Role;
import com.clinic.users.entity.User;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {
    private final SchedulingService schedulingService;
    private final UserRepository userRepository;

    public PatientController(SchedulingService schedulingService, UserRepository userRepository) {
        this.schedulingService = schedulingService;
        this.userRepository = userRepository;
    }

    @GetMapping("/doctors/search")
    public ApiResponse<List<com.clinic.users.AdminDtos.DoctorResponse>> searchDoctors(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String specialty) {
        List<com.clinic.users.AdminDtos.DoctorResponse> doctors = userRepository
                .findByRoleAndFullNameContainingIgnoreCaseAndSpecialtyContainingIgnoreCase(Role.DOCTOR, name, specialty)
                .stream()
                .map(u -> new com.clinic.users.AdminDtos.DoctorResponse(u.getId(), u.getFullName(), u.getEmail(), u.getSpecialty()))
                .toList();
        return ApiResponse.ok("Doctors fetched", doctors);
    }

    @PostMapping("/appointments")
    public ApiResponse<SchedulingDtos.AppointmentResponse> bookAppointment(@AuthenticationPrincipal User user, @Valid @RequestBody SchedulingDtos.BookAppointmentRequest request) {
        return ApiResponse.ok("Appointment booked", schedulingService.bookAppointment(user.getId(), request));
    }

    @GetMapping("/patients/me/appointments")
    public ApiResponse<List<SchedulingDtos.AppointmentResponse>> myAppointments(@AuthenticationPrincipal User user) {
        return ApiResponse.ok("Appointments fetched", schedulingService.patientAppointments(user.getId()));
    }
}
