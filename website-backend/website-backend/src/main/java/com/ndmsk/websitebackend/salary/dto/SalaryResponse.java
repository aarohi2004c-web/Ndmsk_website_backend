package com.ndmsk.websitebackend.salary.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryResponse {

    private Long employeeId;
    private String employeeName;
    private int year;
    private int month;

    private Double monthlySalary;
    private Double totalDeduction;
    private Double finalSalary;
}
