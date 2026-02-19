package com.clinic.assignment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/assignment/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/availability")
    public ResponseEntity<Map<String, Object>> getAvailability(@RequestHeader(value = "Authorization", required = false) String token,
                                                                @RequestParam Long doctorId,
                                                                @RequestParam LocalDate date) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(Map.of("success", false, "message", "Missing or invalid token"));
        }

        List<java.time.LocalTime> slots = doctorService.getAvailableTimeSlots(doctorId, date);
        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Doctor availability fetched",
                "data", Map.of("doctorId", doctorId, "date", date, "availableSlots", slots)
        ));
    }
}
