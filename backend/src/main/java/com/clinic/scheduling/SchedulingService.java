package com.clinic.scheduling;

import com.clinic.users.UserRepository;
import com.clinic.users.entity.Role;
import com.clinic.users.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchedulingService {
    private final AvailabilityRepository availabilityRepository;
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    public SchedulingService(AvailabilityRepository availabilityRepository, AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.availabilityRepository = availabilityRepository;
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    public SchedulingDtos.AvailabilityResponse setAvailability(Long doctorId, SchedulingDtos.AvailabilityRequest request) {
        User doctor = userRepository.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        if (doctor.getRole() != Role.DOCTOR) throw new IllegalArgumentException("Invalid doctor");
        availabilityRepository.deleteByDoctorIdAndAvailableDate(doctorId, request.date());
        request.slots().forEach(slot -> {
            DoctorAvailability d = new DoctorAvailability();
            d.setDoctorId(doctorId);
            d.setAvailableDate(request.date());
            d.setStartTime(slot);
            availabilityRepository.save(d);
        });
        return getAvailability(doctorId, request.date());
    }

    public SchedulingDtos.AvailabilityResponse getAvailability(Long doctorId, LocalDate date) {
        List<java.time.LocalTime> slots = availabilityRepository.findByDoctorIdAndAvailableDate(doctorId, date).stream().map(DoctorAvailability::getStartTime).sorted().toList();
        return new SchedulingDtos.AvailabilityResponse(doctorId, date, slots);
    }

    public SchedulingDtos.AppointmentResponse bookAppointment(Long patientId, SchedulingDtos.BookAppointmentRequest request) {
        userRepository.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        userRepository.findById(request.doctorId()).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

        availabilityRepository.findByDoctorIdAndAvailableDateAndStartTime(request.doctorId(), request.date(), request.time())
                .orElseThrow(() -> new IllegalArgumentException("Requested slot is not available"));

        appointmentRepository.findByDoctorIdAndAppointmentDateAndAppointmentTime(request.doctorId(), request.date(), request.time())
                .ifPresent(a -> { throw new IllegalArgumentException("Slot already booked"); });

        Appointment appointment = new Appointment();
        appointment.setDoctorId(request.doctorId());
        appointment.setPatientId(patientId);
        appointment.setAppointmentDate(request.date());
        appointment.setAppointmentTime(request.time());
        appointment.setStatus(AppointmentStatus.BOOKED);
        return toResponse(appointmentRepository.save(appointment));
    }

    public List<SchedulingDtos.AppointmentResponse> doctorAppointments(Long doctorId, LocalDate date) {
        return appointmentRepository.findByDoctorIdAndAppointmentDate(doctorId, date).stream().map(this::toResponse).toList();
    }

    public List<SchedulingDtos.AppointmentResponse> patientAppointments(Long patientId) {
        return appointmentRepository.findByPatientId(patientId).stream().map(this::toResponse).toList();
    }

    public SchedulingDtos.AppointmentResponse toResponse(Appointment a) {
        return new SchedulingDtos.AppointmentResponse(a.getId(), a.getDoctorId(), a.getPatientId(), a.getAppointmentDate(), a.getAppointmentTime(), a.getStatus().name());
    }
}
