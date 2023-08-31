package com.capstone.dad.kafka;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount3;

@Service
public class KafkaLoanAccount3Consumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaLoanAccount3Consumer.class);

	private final List<LoanAccount3> loanAccount3List = new ArrayList<>();
    private final Object lock = new Object(); // Mutex for synchronization

    @KafkaListener(topics = "loan-account-topic-3", groupId = "loan-account-3-consumer-group")
    public void receiveLoanAccount3(LoanAccount3 loanAccount3) {
    	logger.info("Received FailureReason1&4Count: " + loanAccount3);
        synchronized (lock) {
        	loanAccount3List.add(loanAccount3);
        }
    }

    public List<LoanAccount3> getLoanAccount3List() {
        //to avoid concurrent modification of the list a copy is shared to the other classes
    	synchronized (lock) {
            return new ArrayList<>(loanAccount3List);
        }
    }

    public void clearLoanAccount3List() {
        synchronized (lock) {
        	loanAccount3List.clear();
        }
    }
}
