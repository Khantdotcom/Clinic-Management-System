package com.clinic.users;

import com.clinic.users.entity.Role;
import com.clinic.users.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AdminDtos.DoctorResponse createDoctor(AdminDtos.DoctorUpsertRequest request) {
        userRepository.findByEmail(request.email()).ifPresent(u -> { throw new IllegalArgumentException("Doctor email already exists"); });
        User doctor = new User();
        doctor.setFullName(request.fullName());
        doctor.setEmail(request.email());
        doctor.setPassword(passwordEncoder.encode(request.password()));
        doctor.setRole(Role.DOCTOR);
        doctor.setSpecialty(request.specialty());
        return toResponse(userRepository.save(doctor));
    }

    public List<AdminDtos.DoctorResponse> listDoctors() {
        return userRepository.findByRole(Role.DOCTOR).stream().map(this::toResponse).toList();
    }

    public AdminDtos.DoctorResponse updateDoctor(Long id, AdminDtos.DoctorUpsertRequest request) {
        User doctor = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        if (doctor.getRole() != Role.DOCTOR) throw new IllegalArgumentException("User is not a doctor");
        doctor.setFullName(request.fullName());
        doctor.setEmail(request.email());
        doctor.setPassword(passwordEncoder.encode(request.password()));
        doctor.setSpecialty(request.specialty());
        return toResponse(userRepository.save(doctor));
    }

    public void deleteDoctor(Long id) {
        User doctor = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        userRepository.delete(doctor);
    }

    private AdminDtos.DoctorResponse toResponse(User user) {
        return new AdminDtos.DoctorResponse(user.getId(), user.getFullName(), user.getEmail(), user.getSpecialty());
    }
}
