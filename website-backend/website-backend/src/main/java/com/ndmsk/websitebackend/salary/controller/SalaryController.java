package com.ndmsk.websitebackend.salary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ndmsk.websitebackend.salary.service.SalaryService;
import com.ndmsk.websitebackend.salary.dto.SalaryResponse;

@RestController
@RequestMapping("/api/salary")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;

    @GetMapping("/calculate")
    public SalaryResponse calculateSalary(
            @RequestParam Long employeeId,
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam int absentDays,
            @RequestParam int halfDays
    ) {
        return salaryService.calculateSalary(
                employeeId, year, month, absentDays, halfDays
        );
    }
}
