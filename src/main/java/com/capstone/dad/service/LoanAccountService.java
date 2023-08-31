package com.capstone.dad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount;
import com.capstone.dad.kafka.KafkaLoanAccountConsumer;
import com.capstone.dad.kafka.KafkaLoanAccountProducer;
import com.capstone.dad.repo.LoanAccountRepository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class LoanAccountService {
    private final KafkaLoanAccountConsumer kafkaLoanAccountConsumer;
    private final KafkaLoanAccountProducer kafkaLoanAccountProducer;

    @Autowired
    public LoanAccountService( KafkaLoanAccountConsumer kafkaLoanAccountConsumer, KafkaLoanAccountProducer kafkaLoanAccountProducer) {
        this.kafkaLoanAccountConsumer = kafkaLoanAccountConsumer;
		this.kafkaLoanAccountProducer = kafkaLoanAccountProducer;
    }

    public List<Map<String, Object>> getTotalInterestByCboSrmId() {
    	kafkaLoanAccountConsumer.clearLoanAccountList();
    	kafkaLoanAccountProducer.sendLoanAccounts();

        // Waiting for a reasonable time to allow data to be consumed
        try {
            Thread.sleep(5000);  
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<LoanAccount> loanAccounts = kafkaLoanAccountConsumer.getLoanAccountList();
        
        return loanAccounts.stream()
            .filter(loanAccount -> loanAccount.getCbo_srm_id() != null) // Filter out entries with missing cbo_srm_id
            .collect(Collectors.groupingBy(
                LoanAccount::getCbo_srm_id,
                Collectors.summingDouble(account -> account.getNormal_interest() + account.getPenal_interest())
            ))
            .entrySet().stream()
            .map(entry -> {
                Map<String, Object> result = new HashMap<>();
                result.put("cboSrmId", entry.getKey());
                result.put("totalInterest", entry.getValue());
                return result;
            })
            .collect(Collectors.toList());
    }
    
    
}
