package com.capstone.dad.kafka;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount6;
import com.capstone.dad.repo.LoanAccountRepository6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaLoanAccount6Producer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaLoanAccount6Producer.class);

    @Autowired
    private KafkaTemplate<String, LoanAccount6> kafkaTemplate;

    @Autowired
    private LoanAccountRepository6 goodCustomerRepository;

    public void sendGoodCustomers() {
        List<LoanAccount6> goodCustomers  = goodCustomerRepository.findAll();

        goodCustomers.forEach(account -> {
            logger.info("Sending GoodCustomer: {}", account);
            kafkaTemplate.send("good-customer-topic", account.getCbo_srm_id(), account);
        });
        logger.info("Sent {} GoodCustomer records to Kafka", goodCustomers.size());
    }
}