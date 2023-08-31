package com.capstone.dad.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.dad.service.LoanAccount6Service;
import com.capstone.dad.entity.LoanAccount6;

import java.util.Map;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/analytics")
public class DashboardController6 {
	private final LoanAccount6Service analyticsService;

    @Autowired
    public DashboardController6(LoanAccount6Service analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/good-customer")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public Map<String, Long> getGoodCustomerByCboSrmId() {
        return analyticsService.getCboSrmWiseGoodCustomers();
    }
}