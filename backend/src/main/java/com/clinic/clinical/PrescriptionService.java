package com.clinic.clinical;

import com.clinic.scheduling.Appointment;
import com.clinic.scheduling.AppointmentRepository;
import com.clinic.users.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final AppointmentRepository appointmentRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, AppointmentRepository appointmentRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public PrescriptionDtos.PrescriptionResponse create(User doctor, PrescriptionDtos.CreatePrescriptionRequest request) {
        Appointment appointment = appointmentRepository.findById(request.appointmentId()).orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        if (!appointment.getDoctorId().equals(doctor.getId())) throw new IllegalArgumentException("Doctor can only prescribe for own appointments");
        Prescription p = new Prescription();
        p.setAppointmentId(request.appointmentId());
        p.setDoctorId(doctor.getId());
        p.setDiagnosis(request.diagnosis());
        p.setMedications(request.medications());
        p.setNotes(request.notes());
        return toResponse(prescriptionRepository.save(p));
    }

    public List<PrescriptionDtos.PrescriptionResponse> byAppointment(User user, Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        if (!appointment.getDoctorId().equals(user.getId()) && !appointment.getPatientId().equals(user.getId())) {
            throw new IllegalArgumentException("Not authorized to view this prescription");
        }
        return prescriptionRepository.findByAppointmentId(appointmentId).stream().map(this::toResponse).toList();
    }

    public PrescriptionDtos.PrescriptionResponse toResponse(Prescription p) {
        return new PrescriptionDtos.PrescriptionResponse(p.getId(), p.getAppointmentId(), p.getDoctorId(), p.getDiagnosis(), p.getMedications(), p.getNotes());
    }
}
