package com.ndmsk.websitebackend.hr.dashboard.service;

import com.ndmsk.websitebackend.hr.dashboard.dto.DashboardResponse;
import com.ndmsk.websitebackend.hr.repository.AttendanceRepository;
import com.ndmsk.websitebackend.hr.repository.EmployeeRepository;
import com.ndmsk.websitebackend.repository.LeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    private final LeaveRepository leaveRepository;

    public DashboardResponse getDashboardData() {

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);

        long totalEmployees = employeeRepository.count();

        long presentToday = attendanceRepository
                .countByDateAndStatus(today, "PRESENT");

        long absentToday = attendanceRepository
                .countByDateAndStatus(today, "ABSENT");

        long pendingLeaves = leaveRepository
                .countByStatus("PENDING");

        long totalLeavesThisMonth = leaveRepository
                .countByStartDateBetween(firstDayOfMonth, today);

        return new DashboardResponse(
                totalEmployees,
                presentToday,
                absentToday,
                pendingLeaves,
                totalLeavesThisMonth
        );
    }
}
