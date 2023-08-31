package com.capstone.dad.kafka;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount5;

@Service
public class KafkaLoanAccount5Consumer {
	private final List<LoanAccount5> failureReason5CountList = new ArrayList<>();
    private final Object lock = new Object(); // Mutex for synchronization

    @KafkaListener(topics = "failure-reason-5-count", groupId = "failure-reason-4-count-consumer-group")
    public void receiveFailureReason5Count(LoanAccount5 failureReason5Count) {
        System.out.println("Received FailureReason5Count: " + failureReason5Count);
        synchronized (lock) {
            failureReason5CountList.add(failureReason5Count);
        }
    }

    public List<LoanAccount5> getFailureReason5CountList() {
        //to avoid concurrent modification of the list a copy is shared to the other classes
    	synchronized (lock) {
            return new ArrayList<>(failureReason5CountList);
        }
    }

    public void clearFailureReason5CountList() {
        synchronized (lock) {
        	failureReason5CountList.clear();
        }
    }
}
