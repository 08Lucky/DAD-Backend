package com.capstone.dad.kafka;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount4;

@Service
public class KafkaLoanAccount4Consumer {
    private final List<LoanAccount4> loanAccount4List = new ArrayList<>();
    private final Object lock = new Object(); // Mutex for synchronization

    @KafkaListener(topics = "loan-account-4-topic", groupId = "loan-account-4-consumer-group")
    public void receiveLoanAccount4(LoanAccount4 loanAccount4) {
        //synchronized keyword is used to create synchronized blocks that ensure that only one thread can execute the code within the synchronized block at a time. 
    	synchronized (lock) {
            loanAccount4List.add(loanAccount4);
        }
    }

    public List<LoanAccount4> getLoanAccount4List() {
        //to avoid concurrent modification of the list a copy is shared to the other classes
    	synchronized (lock) {
            return new ArrayList<>(loanAccount4List);
        }
    }

    public void clearLoanAccount4List() {
        synchronized (lock) {
            loanAccount4List.clear();
        }
    }
}
