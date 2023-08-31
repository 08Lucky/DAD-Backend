package com.capstone.dad.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount2;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;


@Service
public class KafkaLoanAccount2Consumer {
    private final List<LoanAccount2> loanAccount2List = new ArrayList<>();
    private final Object lock = new Object();  //A lock object, named lock
    
    @KafkaListener(topics = "loan-account-topic-2", groupId = "loan-account-2-consumer-group")
    public void receiveLoanAccount2(LoanAccount2 loanAccount2) {
        //synchronized keyword is used to create synchronized blocks that ensure that only one thread can execute the code within the synchronized block at a time. 
    	synchronized (lock) {
    		loanAccount2List.add(loanAccount2);
        }
    }

    public List<LoanAccount2> getLoanAccount2List() {
    	//to avoid concurrent modification of the list a copy is shared to the other classes
    	synchronized (lock) {
            return new ArrayList<>(loanAccount2List);
        }
    }
    
    public void clearLoanAccount2List() {
        synchronized (lock) {
            loanAccount2List.clear();
        }
    }
}
