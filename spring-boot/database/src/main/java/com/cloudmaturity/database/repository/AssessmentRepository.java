package com.cloudmaturity.database.repository;

import com.cloudmaturity.database.assessment.Assessment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AssessmentRepository extends MongoRepository<Assessment, String> {

    @Query("{teamName:?0}")
    Assessment findByName(String name);


}
