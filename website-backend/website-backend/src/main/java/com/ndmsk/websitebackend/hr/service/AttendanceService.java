package com.ndmsk.websitebackend.hr.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.ndmsk.websitebackend.hr.entity.*;
import com.ndmsk.websitebackend.hr.repository.*;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    public Attendance markAttendance(Long employeeId, Attendance attendance) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        attendance.setEmployee(employee);
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAll() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> getByEmployee(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }
}
