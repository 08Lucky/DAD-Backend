package com.capstone.dad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.dad.service.LoanAccountService4;

import java.util.Map;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/analytics")
public class DashboardController4 {
    private final LoanAccountService4 analyticsService;

    @Autowired
    public DashboardController4(LoanAccountService4 analyticsService) {
        this.analyticsService = analyticsService;
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping("/cbo-srm-wise-failure1-count")
    public Map<String, Long> getCboSrmWiseFailureCount() {
        return analyticsService.getCboSrmWiseFailureCount();
    }
}


