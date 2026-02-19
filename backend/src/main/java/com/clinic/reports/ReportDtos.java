package com.clinic.reports;

public class ReportDtos {
    public record DailyAppointmentsRow(Long doctorId, java.time.LocalDate date, Long totalAppointments) {}
    public record TopDoctorRow(Long doctorId, String doctorName, Long totalPatients) {}
}
