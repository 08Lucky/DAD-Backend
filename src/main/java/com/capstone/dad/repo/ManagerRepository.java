package com.capstone.dad.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.capstone.dad.entity.Manager;

public interface ManagerRepository extends MongoRepository<Manager, String>{

	Manager findByUsername(String username);
}
