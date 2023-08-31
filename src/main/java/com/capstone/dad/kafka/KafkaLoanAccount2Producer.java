package com.capstone.dad.kafka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount2;
import com.capstone.dad.repo.LoanAccountRepository2;

@Service
public class KafkaLoanAccount2Producer {
    @Autowired
    private KafkaTemplate<String, LoanAccount2> kafkaTemplate;

    @Autowired
    private LoanAccountRepository2 loanAccountRepository2;

    public void sendLoanAccount2() {
        List<LoanAccount2> loanAccounts2 = loanAccountRepository2.findAll();

        for (LoanAccount2 loanAccount : loanAccounts2) {
            kafkaTemplate.send("loan-account-topic-2", loanAccount.getSol_id(), loanAccount);
        }
    }
}
