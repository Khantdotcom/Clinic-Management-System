package com.clinic.config;

import com.clinic.users.UserRepository;
import com.clinic.users.entity.Role;
import com.clinic.users.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seedData(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (userRepository.count() > 0) return;

            User admin = new User();
            admin.setFullName("System Admin");
            admin.setEmail("admin@clinic.com");
            admin.setPassword(encoder.encode("Admin@123"));
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);

            User doctor = new User();
            doctor.setFullName("Dr. Aisha Patel");
            doctor.setEmail("doctor@clinic.com");
            doctor.setPassword(encoder.encode("Doctor@123"));
            doctor.setRole(Role.DOCTOR);
            doctor.setSpecialty("Cardiology");
            userRepository.save(doctor);

            User patient = new User();
            patient.setFullName("John Doe");
            patient.setEmail("patient@clinic.com");
            patient.setPassword(encoder.encode("Patient@123"));
            patient.setRole(Role.PATIENT);
            userRepository.save(patient);
        };
    }
}
