package com.capstone.dad.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.LoanAccount;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;


@Service
public class KafkaLoanAccountConsumer {
    private final List<LoanAccount> loanAccountList = new ArrayList<>();
    private final Object lock = new Object();  //A lock object, named lock
    
    @KafkaListener(topics = "loan-account-topic", groupId = "loan-account-consumer-group")
    public void receiveLoanAccount(LoanAccount loanAccount) {
        //synchronized keyword is used to create synchronized blocks that ensure that only one thread can execute the code within the synchronized block at a time. 
    	synchronized (lock) {
    		loanAccountList.add(loanAccount);
        }
    }

    public List<LoanAccount> getLoanAccountList() {
    	//to avoid concurrent modification of the list a copy is shared to the other classes
    	synchronized (lock) {
            return new ArrayList<>(loanAccountList);
        }
    }
    
    public void clearLoanAccountList() {
        synchronized (lock) {
            loanAccountList.clear();
        }
    }
}
