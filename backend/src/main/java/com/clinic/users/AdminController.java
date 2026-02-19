package com.clinic.users;

import com.clinic.common.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/doctors")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ApiResponse<AdminDtos.DoctorResponse> createDoctor(@Valid @RequestBody AdminDtos.DoctorUpsertRequest request) {
        return ApiResponse.ok("Doctor created", adminService.createDoctor(request));
    }

    @GetMapping
    public ApiResponse<List<AdminDtos.DoctorResponse>> listDoctors() {
        return ApiResponse.ok("Doctors fetched", adminService.listDoctors());
    }

    @PutMapping("/{id}")
    public ApiResponse<AdminDtos.DoctorResponse> updateDoctor(@PathVariable Long id, @Valid @RequestBody AdminDtos.DoctorUpsertRequest request) {
        return ApiResponse.ok("Doctor updated", adminService.updateDoctor(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDoctor(@PathVariable Long id) {
        adminService.deleteDoctor(id);
        return ApiResponse.ok("Doctor deleted", null);
    }
}
