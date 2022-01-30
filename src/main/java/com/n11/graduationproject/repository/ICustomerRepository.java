package com.n11.graduationproject.repository;


import com.n11.graduationproject.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findAllByNationalIdNumber(String nationalIdNumber);

    boolean existsByNationalIdNumber(String nationalIdNumber);

    boolean existsByNationalIdNumberAndDateOfBirthGreaterThan(String nationalIdNumber, LocalDate dateOfBirth);

}
