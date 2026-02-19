package com.clinic.reports;

import com.clinic.common.ApiResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/daily-appointments")
    public ApiResponse<List<ReportDtos.DailyAppointmentsRow>> daily(@RequestParam Long doctorId,
                                                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ApiResponse.ok("Daily report fetched", reportService.dailyAppointments(doctorId, date));
    }

    @GetMapping("/top-doctor/month")
    public ApiResponse<List<ReportDtos.TopDoctorRow>> topMonth(@RequestParam int year, @RequestParam int month) {
        return ApiResponse.ok("Top doctor by month fetched", reportService.topDoctorMonth(year, month));
    }

    @GetMapping("/top-doctor/year")
    public ApiResponse<List<ReportDtos.TopDoctorRow>> topYear(@RequestParam int year) {
        return ApiResponse.ok("Top doctor by year fetched", reportService.topDoctorYear(year));
    }
}
