package com.capstone.dad.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount3;
import com.capstone.dad.kafka.KafkaLoanAccount3Consumer;
import com.capstone.dad.kafka.KafkaLoanAccount3Producer;

@Service
public class LoanAccount3Service {

	private final KafkaLoanAccount3Consumer kafkaFailureReason3CountConsumer;
    private final KafkaLoanAccount3Producer kafkaFailureReason3CountProducer;

    @Autowired
    public LoanAccount3Service( KafkaLoanAccount3Consumer kafkaFailureReason3CountConsumer, KafkaLoanAccount3Producer kafkaFailureReason3CountProducer) {
        this.kafkaFailureReason3CountConsumer = kafkaFailureReason3CountConsumer;
		this.kafkaFailureReason3CountProducer = kafkaFailureReason3CountProducer;
    }
    
    public Map<String, Long> getSolIdWiseFailureCount() {
        kafkaFailureReason3CountConsumer.clearLoanAccount3List();
    	kafkaFailureReason3CountProducer.sendLoanAccount3();
        
    	try {
            Thread.sleep(5000);  
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    	
        List<LoanAccount3> failureReason3Counts = kafkaFailureReason3CountConsumer.getLoanAccount3List(); 
        System.out.println("Fetched " + failureReason3Counts.size() + " records from Kafka.");
        Map<String, Long> solIdWiseFailureCounts = new HashMap<>();
        
        for (LoanAccount3 account : failureReason3Counts) {
            if ("Failure".equals(account.getProcessing_status()) || "Cust_Email_Is_Blank".equals(account.getProcessing_status())) {
                solIdWiseFailureCounts.put(account.getSol_id(), solIdWiseFailureCounts.getOrDefault(account.getSol_id(), 0L) + 1);
            }
        }
        
        return solIdWiseFailureCounts;
    }
    
}