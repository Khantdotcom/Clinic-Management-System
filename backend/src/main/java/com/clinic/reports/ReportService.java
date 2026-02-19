package com.clinic.reports;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {
    private final JdbcTemplate jdbcTemplate;

    public ReportService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ReportDtos.DailyAppointmentsRow> dailyAppointments(Long doctorId, LocalDate date) {
        return jdbcTemplate.query("CALL sp_daily_appointments_by_doctor(?, ?)",
                (rs, i) -> new ReportDtos.DailyAppointmentsRow(rs.getLong("doctor_id"), rs.getDate("appointment_date").toLocalDate(), rs.getLong("total_appointments")),
                doctorId, date);
    }

    public List<ReportDtos.TopDoctorRow> topDoctorMonth(int year, int month) {
        return jdbcTemplate.query("CALL sp_top_doctor_by_month(?, ?)",
                (rs, i) -> new ReportDtos.TopDoctorRow(rs.getLong("doctor_id"), rs.getString("doctor_name"), rs.getLong("total_patients")),
                year, month);
    }

    public List<ReportDtos.TopDoctorRow> topDoctorYear(int year) {
        return jdbcTemplate.query("CALL sp_top_doctor_by_year(?)",
                (rs, i) -> new ReportDtos.TopDoctorRow(rs.getLong("doctor_id"), rs.getString("doctor_name"), rs.getLong("total_patients")),
                year);
    }
}
