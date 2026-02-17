package com.ndmsk.websitebackend.salary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ndmsk.websitebackend.hr.entity.Employee;
import com.ndmsk.websitebackend.hr.repository.EmployeeRepository;
import com.ndmsk.websitebackend.salary.dto.SalaryResponse;

@Service
@RequiredArgsConstructor
public class SalaryService {

    private final EmployeeRepository employeeRepository;

    public SalaryResponse calculateSalary(Long employeeId,
                                          int year,
                                          int month,
                                          int absentDays,
                                          int halfDays) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeId));

        if (employee.getSalary() == null) {
            throw new RuntimeException("Salary not set for employee ID: " + employeeId);
        }

        double baseSalary = employee.getSalary();

        double perDaySalary = baseSalary / 30;

        double deduction = (absentDays * perDaySalary)
                + (halfDays * (perDaySalary / 2));

        double finalSalary = baseSalary - deduction;

        return SalaryResponse.builder()
                .employeeId(employee.getId())
                .employeeName(employee.getName())
                .year(year)
                .month(month)
                .monthlySalary(baseSalary)
                .totalDeduction(deduction)
                .finalSalary(finalSalary)
                .build();
    }
}
