package com.n11.graduationproject.repository;

import com.n11.graduationproject.model.CreditScore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICreditScoreRepository extends MongoRepository<CreditScore, String> {

    Optional<CreditScore> findByNationalIdNumber(String nationalIdNumber);

    boolean existsByNationalIdNumber(String nationalIdNumber);
}
