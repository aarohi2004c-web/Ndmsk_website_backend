package com.ndmsk.websitebackend.hr.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    private long totalEmployees;
    private long presentToday;
    private long absentToday;
    private long pendingLeaves;
    private long totalLeavesThisMonth;
}
