package com.capstone.dad.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capstone.dad.entity.LoanAccount;

public interface LoanAccountRepository extends MongoRepository<LoanAccount, String> {
    // You can add custom query methods if needed
}


