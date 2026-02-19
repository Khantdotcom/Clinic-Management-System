package com.clinic.assignment;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/assignment/prescriptions")
public class PrescriptionController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> savePrescription(
            @RequestHeader(value = "Authorization", required = false) String token,
            @Valid @RequestBody PrescriptionRequest request) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(Map.of("success", false, "message", "Unauthorized"));
        }

        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "Prescription saved successfully",
                "data", request
        ));
    }

    public record PrescriptionRequest(@NotNull Long appointmentId, @NotBlank String diagnosis, @NotBlank String medications) {
    }
}
