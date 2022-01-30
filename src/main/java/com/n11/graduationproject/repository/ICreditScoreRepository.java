package com.n11.graduationproject.repository;

import com.n11.graduationproject.model.CreditScore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICreditScoreRepository extends MongoRepository<CreditScore, String> {


}
