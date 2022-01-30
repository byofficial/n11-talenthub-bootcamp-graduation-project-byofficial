package com.n11.graduationproject.service;

import com.n11.graduationproject.dto.request.CreateCustomerDto;
import com.n11.graduationproject.dto.response.LoanResultDto;

import java.time.LocalDate;
import java.util.List;

public interface ILoanResultService {
    List<LoanResultDto> findAll();

    LoanResultDto findByNationalIdNumberAndDateOfBirth(String nationalId, LocalDate dateOfBirth);

    LoanResultDto resultLoanCalculateForRegisteredCustomer(String nationalId);

    LoanResultDto resultLoanCalculateForNewCustomer(CreateCustomerDto createCustomerDto);
}
