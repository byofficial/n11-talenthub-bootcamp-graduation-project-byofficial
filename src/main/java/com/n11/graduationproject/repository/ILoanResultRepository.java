package com.n11.graduationproject.repository;

import com.n11.graduationproject.dto.response.LoanResultDto;
import com.n11.graduationproject.model.LoanResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoanResultRepository extends MongoRepository<LoanResult, String> {

    LoanResultDto findByNationalIdNumber(String nationalIdNumber);
}

