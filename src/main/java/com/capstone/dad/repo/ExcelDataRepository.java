package com.capstone.dad.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.capstone.dad.entity.ExcelData;

@Repository
public interface ExcelDataRepository extends MongoRepository<ExcelData, String> {
	@Query(value = "{ 'sr_no' : ?0 }", exists = true)
    boolean existsBySr_no(Double sr_no);
}
