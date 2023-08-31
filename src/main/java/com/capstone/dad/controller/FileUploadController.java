package com.capstone.dad.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.dad.kafka.ExcelDataProducer;
import com.capstone.dad.kafka.ExcelDataScheduler;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

	private final ExcelDataScheduler excelDataLoader;

	@Autowired
    public FileUploadController(ExcelDataScheduler excelDataLoader) {
        this.excelDataLoader = excelDataLoader;
    }

	@PreAuthorize("hasRole('ROLE_MANAGER')")
	@PostMapping("/load-excel-data")
    public ResponseEntity<String> loadExcelDataManually(@RequestParam("file") MultipartFile file) {
        excelDataLoader.loadExcelData(file); // Manually trigger data loading with the uploaded file
        return ResponseEntity.status(HttpStatus.OK).body("Excel data loading initiated.");
    }
}
