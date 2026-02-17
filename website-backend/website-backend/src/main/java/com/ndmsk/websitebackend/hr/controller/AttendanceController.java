package com.ndmsk.websitebackend.hr.controller;

import com.ndmsk.websitebackend.hr.entity.Attendance;
import com.ndmsk.websitebackend.hr.entity.Employee;
import com.ndmsk.websitebackend.hr.repository.AttendanceRepository;
import com.ndmsk.websitebackend.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/hr")
@CrossOrigin
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Mark Attendance
    @PostMapping("/attendance")
    public Attendance markAttendance(@RequestParam Long employeeId,
                                     @RequestParam String status) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Attendance attendance = new Attendance();
        attendance.setEmployee(employee);
        attendance.setDate(LocalDate.now());
        attendance.setStatus(status);

        return attendanceRepository.save(attendance);
    }

    // Get All Attendance
    @GetMapping("/attendance")
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get Attendance By Employee
    @GetMapping("/attendance/employee/{id}")
    public List<Attendance> getByEmployee(@PathVariable Long id) {
        return attendanceRepository.findByEmployeeId(id);
    }

    // Delete Attendance
    @DeleteMapping("/attendance/{id}")
    public String deleteAttendance(@PathVariable Long id) {
        attendanceRepository.deleteById(id);
        return "Attendance deleted successfully";
    }
}