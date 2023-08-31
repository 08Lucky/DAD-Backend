package com.capstone.dad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.dad.service.LoanAccountService;
import com.capstone.dad.entity.LoanAccount;

import java.util.Map;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/analytics")
public class DashboardController {
	private final LoanAccountService analyticsService;

    @Autowired
    public DashboardController(LoanAccountService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/total-interest-by-cbo-srm")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public List<Map<String, Object>> getTotalInterestByCboSrmId() {
        return analyticsService.getTotalInterestByCboSrmId();
    }
}


