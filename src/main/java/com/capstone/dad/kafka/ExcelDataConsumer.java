package com.capstone.dad.kafka;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.ExcelData;
import com.capstone.dad.repo.ExcelDataRepository;

@Service
public class ExcelDataConsumer {

	private final ExcelDataRepository excelDataRepository;

    public ExcelDataConsumer(ExcelDataRepository excelDataRepository) {
        this.excelDataRepository = excelDataRepository;
    }

    @KafkaListener(topics = "excel-data-topic", groupId = "excel-data-group")
    public void consumeExcelData(ExcelData excelData) {
        // Check if the data already exists in the database based on some unique identifier
        if (!excelDataRepository.existsBySr_no(excelData.getSr_no())) {
            excelDataRepository.save(excelData);
        }
    }
}
