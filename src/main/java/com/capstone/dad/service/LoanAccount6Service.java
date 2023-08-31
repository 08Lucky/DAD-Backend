package com.capstone.dad.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount6;
import com.capstone.dad.kafka.KafkaLoanAccount6Consumer;
import com.capstone.dad.kafka.KafkaLoanAccount6Producer;

@Service
public class LoanAccount6Service {

	private final KafkaLoanAccount6Consumer kafkaLoanAccount6Consumer;
    private final KafkaLoanAccount6Producer kafkaLoanAccount6Producer;

    @Autowired
    public LoanAccount6Service( KafkaLoanAccount6Consumer kafkaLoanAccount6Consumer, KafkaLoanAccount6Producer kafkaLoanAccount6Producer) {
        this.kafkaLoanAccount6Consumer = kafkaLoanAccount6Consumer;
		this.kafkaLoanAccount6Producer = kafkaLoanAccount6Producer;
    }
    
    public Map<String, Long> getCboSrmWiseGoodCustomers() {
    	kafkaLoanAccount6Consumer.clearGoodCustomerList();
    	kafkaLoanAccount6Producer.sendGoodCustomers();
        
    	try {
            Thread.sleep(3000);  
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    	
        List<LoanAccount6> goodCustomers  = kafkaLoanAccount6Consumer.getGoodCustomerList(); 
        System.out.println("Fetched " + goodCustomers.size() + " records from Kafka.");
        Map<String, Long> cboSrmWiseGoodCustomers  = new HashMap<>();
        
        for (LoanAccount6 customer : goodCustomers) {
            if (isEligibleAsGoodCustomer(customer)) {
            	cboSrmWiseGoodCustomers.put(
                    customer.getCbo_srm_id(),
                    cboSrmWiseGoodCustomers.getOrDefault(customer.getCbo_srm_id(), 0L) + 1
                );
            }
        }

        return cboSrmWiseGoodCustomers;
    }

    private boolean isEligibleAsGoodCustomer(LoanAccount6 customer) {
        // Check if the customer meets the conditions to be considered a good customer
        boolean isValidReason2 = customer.getPrincipal_payment_due_date() == null;
        boolean isValidReason3 = customer.getNormal_interest() == null || customer.getNormal_interest() == 0;

        return isValidReason2 || isValidReason3;
    }
}
