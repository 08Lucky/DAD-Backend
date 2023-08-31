package com.capstone.dad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount2;
import com.capstone.dad.kafka.KafkaLoanAccount2Consumer;
import com.capstone.dad.kafka.KafkaLoanAccount2Producer;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class LoanAccount2Service {
    private final KafkaLoanAccount2Consumer kafkaLoanAccount2Consumer;
    private final KafkaLoanAccount2Producer kafkaLoanAccount2Producer;

    @Autowired
    public LoanAccount2Service( KafkaLoanAccount2Consumer kafkaLoanAccount2Consumer, KafkaLoanAccount2Producer kafkaLoanAccount2Producer) {
        this.kafkaLoanAccount2Consumer = kafkaLoanAccount2Consumer;
		this.kafkaLoanAccount2Producer = kafkaLoanAccount2Producer;
    }

    public List<Map<String, Object>> getTotalInterestBySolId() {
    	kafkaLoanAccount2Consumer.clearLoanAccount2List();
    	kafkaLoanAccount2Producer.sendLoanAccount2();

        // Waiting for a reasonable time to allow data to be consumed
        try {
            Thread.sleep(5000);  
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<LoanAccount2> loanAccount2 = kafkaLoanAccount2Consumer.getLoanAccount2List();
        
        return loanAccount2.stream()
            .filter(loanAccount -> loanAccount.getSol_id() != null) // Filter out entries with missing cbo_srm_id
            .collect(Collectors.groupingBy(
                LoanAccount2::getSol_id,
                Collectors.summingDouble(account -> account.getNormal_interest() + account.getPenal_interest())
            ))
            .entrySet().stream()
            .map(entry -> {
                Map<String, Object> result = new HashMap<>();
                result.put("sol_id", entry.getKey());
                result.put("totalInterest", entry.getValue());
                return result;
            })
            .collect(Collectors.toList());
    }
    
    
}

