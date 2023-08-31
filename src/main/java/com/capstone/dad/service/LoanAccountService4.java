package com.capstone.dad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount;
import com.capstone.dad.entity.LoanAccount4;
import com.capstone.dad.kafka.KafkaLoanAccount4Consumer;
import com.capstone.dad.kafka.KafkaLoanAccount4Producer;
import com.capstone.dad.kafka.KafkaLoanAccountConsumer;
import com.capstone.dad.kafka.KafkaLoanAccountProducer;
import com.capstone.dad.repo.LoanAccountRepository4;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class LoanAccountService4 {
	
    private final KafkaLoanAccount4Consumer kafkaLoanAccount4Consumer;
    private final KafkaLoanAccount4Producer kafkaLoanAccount4Producer;
    @Autowired
    public LoanAccountService4( KafkaLoanAccount4Consumer kafkaLoanAccount4Consumer, KafkaLoanAccount4Producer kafkaLoanAccount4Producer) {
        this.kafkaLoanAccount4Consumer = kafkaLoanAccount4Consumer;
		this.kafkaLoanAccount4Producer = kafkaLoanAccount4Producer;
    }

    public Map<String, Long> getCboSrmWiseFailureCount() {
    	kafkaLoanAccount4Consumer.clearLoanAccount4List();
    	kafkaLoanAccount4Producer.sendLoanAccounts4();
        
        List<LoanAccount4> loanAccounts4 = kafkaLoanAccount4Consumer.getLoanAccount4List();        
        Map<String, Long> cboSrmWiseFailureCount = new HashMap<>();
        
        for (LoanAccount4 account : loanAccounts4) {
            if ("Failure".equals(account.getProcessing_status())) {
                cboSrmWiseFailureCount.put(account.getCbo_srm_id(), cboSrmWiseFailureCount.getOrDefault(account.getCbo_srm_id(), 0L) + 1);
            }
        }
        
        return cboSrmWiseFailureCount;
    }
}

