package com.capstone.dad.kafka;
import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount6;

@Service
public class KafkaLoanAccount6Consumer {
	private final List<LoanAccount6> goodCustomerList = new ArrayList<>();
    private final Object lock = new Object(); // Mutex for synchronization

    @KafkaListener(topics = "good-customer-topic", groupId = "good-customer-consumer-group")
    public void receiveGoodCustomer(LoanAccount6 goodCustomer) {
        System.out.println("Received GoodCustomer: " + goodCustomer);
        synchronized (lock) {
        	goodCustomerList.add(goodCustomer);
        }
    }

    public List<LoanAccount6> getGoodCustomerList() {
        //to avoid concurrent modification of the list a copy is shared to the other classes
    	synchronized (lock) {
            return new ArrayList<>(goodCustomerList);
        }
    }

    public void clearGoodCustomerList() {
        synchronized (lock) {
        	goodCustomerList.clear();
        }
    }
}