package com.capstone.dad.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capstone.dad.entity.LoanAccount2;

public interface LoanAccountRepository2 extends MongoRepository<LoanAccount2, String> {
    // You can add custom query methods if needed
}
