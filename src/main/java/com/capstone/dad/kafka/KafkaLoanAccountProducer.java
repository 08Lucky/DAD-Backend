package com.capstone.dad.kafka;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount;
import com.capstone.dad.repo.LoanAccountRepository;

@Service
public class KafkaLoanAccountProducer {
    @Autowired
    private KafkaTemplate<String, LoanAccount> kafkaTemplate;

    @Autowired
    private LoanAccountRepository loanAccountRepository;

    public void sendLoanAccounts() {
        List<LoanAccount> loanAccounts = loanAccountRepository.findAll();

        for (LoanAccount loanAccount : loanAccounts) {
            kafkaTemplate.send("loan-account-topic", loanAccount.getCbo_srm_id(), loanAccount);
        }
    }
}

