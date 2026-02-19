package com.clinic.scheduling;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface AvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {
    List<DoctorAvailability> findByDoctorIdAndAvailableDate(Long doctorId, LocalDate date);
    void deleteByDoctorIdAndAvailableDate(Long doctorId, LocalDate date);
    Optional<DoctorAvailability> findByDoctorIdAndAvailableDateAndStartTime(Long doctorId, LocalDate date, LocalTime startTime);
}
