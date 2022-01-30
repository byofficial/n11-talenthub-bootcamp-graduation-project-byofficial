package com.n11.graduationproject.controller;

import com.n11.graduationproject.dto.request.CreateCustomerDto;
import com.n11.graduationproject.dto.response.LoanResultDto;
import com.n11.graduationproject.service.ILoanResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/loan-request")
public class LoanResultController {

    private final ILoanResultService loanResultService;

    @Autowired
    public LoanResultController(ILoanResultService loanResultService) {
        this.loanResultService = loanResultService;
    }

    @PostMapping("/new-customer")
    public ResponseEntity<LoanResultDto> resultLoanCalculateForNewCustomer(@RequestBody @Valid CreateCustomerDto createCustomerDto) {
        LoanResultDto loanResultDto = loanResultService.resultLoanCalculateForNewCustomer(createCustomerDto);
        return new ResponseEntity<>(loanResultDto, HttpStatus.OK);
    }

    @PostMapping("/{nationalId}")
    public ResponseEntity<LoanResultDto> resultLoanCalculateForRegisteredCustomer(@PathVariable String nationalId) {
        LoanResultDto loanResultDto = loanResultService.resultLoanCalculateForRegisteredCustomer(nationalId);
        return new ResponseEntity<>(loanResultDto, HttpStatus.OK);
    }

    @GetMapping("/q")
    public ResponseEntity<LoanResultDto> findByNationalIdNumberAndDateOfBirth(@RequestParam(required = false) String nationalId,
                                                                              @RequestParam(required = false) String dateOfBirth) throws ParseException {



        LoanResultDto loanResultDto = loanResultService.findByNationalIdNumberAndDateOfBirth(nationalId, LocalDate.parse(dateOfBirth));
        return new ResponseEntity<>(loanResultDto, HttpStatus.OK);
    }

}

