package com.capstone.dad.kafka;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount3;
import com.capstone.dad.repo.LoanAccountRepository3;

@Service
public class KafkaLoanAccount3Producer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaLoanAccount3Producer.class);

    @Autowired
    private KafkaTemplate<String, LoanAccount3> kafkaTemplate;

    @Autowired
    private LoanAccountRepository3 loanAccountRepository2;

    public void sendLoanAccount3() {
        List<LoanAccount3> loanAccounts3 = loanAccountRepository2.findAll();

        loanAccounts3.forEach(account -> {
            logger.info("Sending FailureReason4Count: {}", account);
            kafkaTemplate.send("loan-account-topic-3", account.getSol_id(), account);
        });
        logger.info("Sent {} FailureReason4Count records to Kafka", loanAccounts3.size());

    }
}
