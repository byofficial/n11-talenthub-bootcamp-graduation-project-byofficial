package com.n11.graduationproject.service.impl;

import com.n11.graduationproject.dto.response.LoanResultDto;
import com.n11.graduationproject.repository.ILoanResultRepository;
import com.n11.graduationproject.service.ICreditScoreService;
import com.n11.graduationproject.service.ICustomerService;
import com.n11.graduationproject.service.ILoanResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Slf4j
public class LoanResultServiceImpl implements ILoanResultService {

    public static final int CREDIT_LIMIT_FACTOR = 4;
    private final String CLASS_NAME_LOG = this.getClass().getSimpleName();
    private final ILoanResultRepository loanResultRepository;

    private final ICreditScoreService creditScoreService;
    private final ICustomerService customerService;

    @Autowired
    public LoanResultServiceImpl(ILoanResultRepository loanResultRepository, ICreditScoreService creditScoreService, ICustomerService customerService) {
        this.loanResultRepository = loanResultRepository;
        this.creditScoreService = creditScoreService;
        this.customerService = customerService;
    }


    /**
     * @return Returns all loan result
     */
    @Override
    public List<LoanResultDto> findAll() {
        log.info(CLASS_NAME_LOG + " service findAll method is running.");
        List<LoanResultDto> loanResultDtoList = LoanResultMapper.INSTANCE.mapFromLoanResultListToLoanResultDto(loanResultRepository.findAll());
        return loanResultDtoList;
    }

    @Override
    public LoanResultDto findByNationalIdNumberAndDateOfBirth(String nationalId, LocalDate dateOfBirth){
        log.info(CLASS_NAME_LOG + " service findAll method is running.");


        boolean isCustomerExist = customerService.existsByNationalIdNumberAndDateOfBirthGreaterThan(nationalId, dateOfBirth);

        if (!isCustomerExist) {
            log.error("Customer NationalID: " + nationalId + " is already exists!");
            throw new CustomerAlreadyExistException("Customer NationalID: " + nationalId);
        }

        LoanResultDto loanResultDto = loanResultRepository.findByNationalIdNumber(nationalId);
        return loanResultDto;
    }
    private LoanResultDto save(LoanResultDto loanResultDto) {
        log.info(CLASS_NAME_LOG + " service loanResultDto method is running.");

        LoanResult loanResult = LoanResultMapper.INSTANCE.mapFromLoanResultDtoToLoanResult(loanResultDto);
        loanResult.setCreatedDate(LocalDateTime.now());

        LoanResultDto newLoanResultDto = LoanResultMapper.INSTANCE.mapFromLoanResultToLoanResultDto(loanResultRepository.save(loanResult));

        log.info("Loan result is saved");

        return newLoanResultDto;
    }



    @Override
    public LoanResultDto resultLoanCalculateForRegisteredCustomer(String nationalId) {
        log.info(CLASS_NAME_LOG + " service resultLoanCalculateForRegisteredCustomer method is running.");
        LoanResultDto loanResultDto = new LoanResultDto();
        CustomerDto customerDto = customerService.findByNationalId(nationalId);

        double creditScore = creditScoreService.getCreditScore(customerDto.getNationalIdNumber()).doubleValue();
        double monthlyIncome = customerDto.getMonthlyIncome().doubleValue();
        BigDecimal guarantee = customerDto.getGuarantee();

        loanResultDto = calculateLoanResult(loanResultDto, customerDto, creditScore, monthlyIncome, guarantee);
        log.info("Loan Result is saved.");

        return loanResultDto;
    }


    @Override
    public LoanResultDto resultLoanCalculateForNewCustomer(CreateCustomerDto createCustomerDto) {
        log.info(CLASS_NAME_LOG + " service resultLoanCalculateForNewCustomer method is running.");

        LoanResultDto loanResultDto = new LoanResultDto();
        double creditScore = creditScoreService.getCreditScore(createCustomerDto.getNationalIdNumber()).doubleValue();
        double monthlyIncome = createCustomerDto.getMonthlyIncome().doubleValue();
        BigDecimal guarantee = createCustomerDto.getGuarantee();

        CustomerDto customerDto = CustomerMapper.INSTANCE.mapFromCreateCustomerDtoToCustomerDto(createCustomerDto);

        loanResultDto = calculateLoanResult(loanResultDto, customerDto, creditScore, monthlyIncome, guarantee);
        log.info("Loan Result is saved.");

        customerService.save(createCustomerDto);

        return loanResultDto;
    }

    private LoanResultDto calculateLoanResult(LoanResultDto loanResultDto, CustomerDto customerDto, double creditScore, double monthlyIncome, BigDecimal guarantee) {
        log.info(CLASS_NAME_LOG + " service calculateLoanResult method is running.");

        if (creditScore < 500) {
            loanResultDto.setStatus(LoanStatus.Denied);
            loanResultDto.setCreditLimit(BigDecimal.valueOf(0L));
        } else if ((creditScore >= 500 && creditScore < 1000) && monthlyIncome <= 5000) {
            if (guarantee != null || guarantee.doubleValue() != 0) {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(10000L + guarantee.doubleValue() * 0.1));
            } else {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(10000L));
            }
            loanResultDto.setStatus(LoanStatus.Accepted);
        } else if ((creditScore >= 500 && creditScore < 1000) && (monthlyIncome > 5000 && monthlyIncome <= 10000)) {
            if (guarantee != null || guarantee.doubleValue() != 0) {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(20000L + guarantee.doubleValue() * 0.2));
            } else {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(20000L));
            }
            loanResultDto.setStatus(LoanStatus.Accepted);
        } else if ((creditScore >= 500 && creditScore < 1000) && monthlyIncome > 10000) {
            if (guarantee != null || guarantee.doubleValue() != 0) {
                loanResultDto.setCreditLimit(
                        BigDecimal.valueOf((monthlyIncome * (CREDIT_LIMIT_FACTOR / 2.0))
                                + guarantee.doubleValue() * 0.25));
            } else {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(monthlyIncome * (CREDIT_LIMIT_FACTOR / 2.0)));
            }
            loanResultDto.setStatus(LoanStatus.Accepted);
        } else if (creditScore >= 1000) {
            if (guarantee != null || guarantee.doubleValue() != 0) {
                loanResultDto.setCreditLimit(
                        BigDecimal.valueOf((monthlyIncome * CREDIT_LIMIT_FACTOR) + guarantee.doubleValue() * 0.5));
            } else {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(monthlyIncome * CREDIT_LIMIT_FACTOR));
            }
            loanResultDto.setStatus(LoanStatus.Accepted);
        }

        loanResultDto.setNationalIdNumber(customerDto.getNationalIdNumber());
        loanResultDto.setCreatedTime(LocalDateTime.now());

        LoanResultDto loanResult = save(loanResultDto);

        log.info("Loan Result is calculated.");
        return loanResult;
    }
}

