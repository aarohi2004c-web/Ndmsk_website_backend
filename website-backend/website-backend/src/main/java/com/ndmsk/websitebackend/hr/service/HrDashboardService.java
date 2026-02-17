package com.ndmsk.websitebackend.hr.service;

import com.ndmsk.websitebackend.hr.repository.AttendanceRepository;
import com.ndmsk.websitebackend.hr.repository.EmployeeRepository;

import com.ndmsk.websitebackend.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HrDashboardService {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    private final LeaveRepository leaveRepository;

    public HrDashboardService(EmployeeRepository employeeRepository,
                              AttendanceRepository attendanceRepository,
                              LeaveRepository leaveRepository) {
        this.employeeRepository = employeeRepository;
        this.attendanceRepository = attendanceRepository;
        this.leaveRepository = leaveRepository;
    }

    public Map<String, Long> getSummary() {
        Map<String, Long> summary = new HashMap<>();

        summary.put("totalEmployees", employeeRepository.count());
        summary.put("totalAttendanceRecords", attendanceRepository.count());
        summary.put("totalLeaves", leaveRepository.count());

        return summary;
    }
}
