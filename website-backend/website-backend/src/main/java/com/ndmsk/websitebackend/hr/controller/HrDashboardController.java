package com.ndmsk.websitebackend.hr.controller;

import com.ndmsk.websitebackend.hr.service.HrDashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/hr")
public class HrDashboardController {

    private final HrDashboardService hrDashboardService;

    public HrDashboardController(HrDashboardService hrDashboardService) {
        this.hrDashboardService = hrDashboardService;
    }

    @GetMapping("/summary")
    public Map<String, Long> getSummary() {
        return hrDashboardService.getSummary();
    }
}
