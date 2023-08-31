package com.capstone.dad.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount5;
import com.capstone.dad.entity.LoanAccount4;
import com.capstone.dad.kafka.KafkaLoanAccount5Consumer;
import com.capstone.dad.kafka.KafkaLoanAccount5Producer;

@Service
public class LoanAccount5Service {

	private final KafkaLoanAccount5Consumer kafkaFailureReason5CountConsumer;
    private final KafkaLoanAccount5Producer kafkaFailureReason5CountProducer;

    @Autowired
    public LoanAccount5Service( KafkaLoanAccount5Consumer kafkaFailureReason5CountConsumer, KafkaLoanAccount5Producer kafkaFailureReason5CountProducer) {
        this.kafkaFailureReason5CountConsumer = kafkaFailureReason5CountConsumer;
		this.kafkaFailureReason5CountProducer = kafkaFailureReason5CountProducer;
    }
    
    public Map<String, Long> getCboSrmWiseFailureCount() {
    	kafkaFailureReason5CountConsumer.clearFailureReason5CountList();
    	kafkaFailureReason5CountProducer.sendFailureReason5Counts();
        
    	try {
            Thread.sleep(3000);  
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    	
        List<LoanAccount5> failureReason4Counts = kafkaFailureReason5CountConsumer.getFailureReason5CountList(); 
        System.out.println("Fetched " + failureReason4Counts.size() + " records from Kafka.");
        Map<String, Long> cboSrmWiseFailureCount = new HashMap<>();
        
        for (LoanAccount5 account : failureReason4Counts) {
            if ("Cust_Email_Is_Blank".equals(account.getProcessing_status())) {
                cboSrmWiseFailureCount.put(account.getCbo_srm_id(), cboSrmWiseFailureCount.getOrDefault(account.getCbo_srm_id(), 0L) + 1);
            }
        }
        
        return cboSrmWiseFailureCount;
    }
    
}
