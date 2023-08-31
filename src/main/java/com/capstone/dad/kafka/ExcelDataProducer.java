package com.capstone.dad.kafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.ExcelData;

@Service
public class ExcelDataProducer {

    private final KafkaTemplate<String, ExcelData> kafkaTemplate;
    private final String topic = "excel-data-topic"; 

    public ExcelDataProducer(KafkaTemplate<String, ExcelData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendExcelData(ExcelData excelData) {
        kafkaTemplate.send(topic, excelData);
    }
}
