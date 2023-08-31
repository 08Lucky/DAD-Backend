package com.capstone.dad.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.dad.service.LoanAccount3Service;
import com.capstone.dad.entity.LoanAccount3;

import java.util.Map;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/analytics")
public class DashboardController3 {
	private final LoanAccount3Service analyticsService;

    @Autowired
    public DashboardController3(LoanAccount3Service analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/sol-id-wise-failure1-count")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public Map<String, Long> getSolIdWiseFailureCounts() {
        return analyticsService.getSolIdWiseFailureCount();
    }
}