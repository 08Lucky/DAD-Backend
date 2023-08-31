package com.capstone.dad.kafka;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount5;
import com.capstone.dad.repo.LoanAccountRepository5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaLoanAccount5Producer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaLoanAccount5Producer.class);

    @Autowired
    private KafkaTemplate<String, LoanAccount5> kafkaTemplate;

    @Autowired
    private LoanAccountRepository5 failureReason4CountRepository;

    public void sendFailureReason5Counts() {
        List<LoanAccount5> failureReason4CountList = failureReason4CountRepository.findAll();

        failureReason4CountList.forEach(account -> {
            logger.info("Sending FailureReason4Count: {}", account);
            kafkaTemplate.send("failure-reason-5-count", account.getCbo_srm_id(), account);
        });
        logger.info("Sent {} FailureReason4Count records to Kafka", failureReason4CountList.size());
    }
}
