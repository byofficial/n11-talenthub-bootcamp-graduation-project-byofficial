package com.n11.graduationproject.service;

import com.n11.graduationproject.dto.request.CreateCustomerDto;
import com.n11.graduationproject.dto.request.UpdateCustomerDto;
import com.n11.graduationproject.dto.response.CustomerDto;

import java.time.LocalDate;
import java.util.List;

public interface ICustomerService {

    List<CustomerDto> findAll();

    CustomerDto findByNationalId(String nationalId);

    boolean existsByNationalIdNumberAndDateOfBirthGreaterThan(String nationalId, LocalDate dateOfBirth);

    CustomerDto save(CreateCustomerDto createCustomerDto);

    CustomerDto update(String nationalId, UpdateCustomerDto updateCustomerDto);

    void delete(String nationalId);
}
