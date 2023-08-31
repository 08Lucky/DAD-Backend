package com.capstone.dad.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount4;
import com.capstone.dad.repo.LoanAccountRepository4;

@Service
public class KafkaLoanAccount4Producer {
    @Autowired
    private KafkaTemplate<String, LoanAccount4> kafkaTemplate;

    @Autowired
    private LoanAccountRepository4 loanAccountRepository4;

    public void sendLoanAccounts4() {
        List<LoanAccount4> loanAccounts4 = loanAccountRepository4.findAll();

        loanAccounts4.forEach(account -> {
            System.out.println("Sending LoanAccount4: " + account);
            kafkaTemplate.send("loan-account-4-topic", account.getId(), account);
        });
    }
}

