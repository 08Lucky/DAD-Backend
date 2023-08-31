package com.capstone.dad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.dad.service.LoanAccount2Service;

import java.util.Map;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/analytics")
public class DashboardController2 {

	private final LoanAccount2Service analyticsService;

    @Autowired
    public DashboardController2(LoanAccount2Service analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/total-interest-by-sol-id")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public List<Map<String, Object>> getTotalInterestByCboSrmId() {
        return analyticsService.getTotalInterestBySolId();
    }
}
