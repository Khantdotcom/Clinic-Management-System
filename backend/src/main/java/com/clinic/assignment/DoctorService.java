package com.clinic.assignment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {
    public List<LocalTime> getAvailableTimeSlots(Long doctorId, LocalDate date) {
        return List.of(LocalTime.of(9, 0), LocalTime.of(9, 30), LocalTime.of(10, 0));
    }

    public ResponseEntity<Map<String, Object>> validateLogin(String email, String password) {
        boolean valid = "doctor@clinic.com".equalsIgnoreCase(email) && "Doctor@123".equals(password);
        if (!valid) {
            return ResponseEntity.status(401).body(Map.of("success", false, "message", "Invalid credentials"));
        }
        return ResponseEntity.ok(Map.of("success", true, "message", "Doctor login successful", "email", email));
    }
}
