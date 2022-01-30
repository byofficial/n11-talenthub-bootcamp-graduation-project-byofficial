package com.n11.graduationproject.service.impl;

import com.n11.graduationproject.dto.request.CreateCustomerDto;
import com.n11.graduationproject.dto.response.CustomerDto;
import com.n11.graduationproject.dto.response.LoanResultDto;
import com.n11.graduationproject.exception.customer.CustomerNotFoundException;
import com.n11.graduationproject.mapper.CustomerMapper;
import com.n11.graduationproject.mapper.LoanResultMapper;
import com.n11.graduationproject.model.LoanResult;
import com.n11.graduationproject.model.enums.LoanStatus;
import com.n11.graduationproject.notification.ICustomerSMSNotification;
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

    private final ICustomerSMSNotification customerSMSNotification;

    @Autowired
    public LoanResultServiceImpl(ILoanResultRepository loanResultRepository, ICreditScoreService creditScoreService, ICustomerService customerService, ICustomerSMSNotification customerSMSNotification) {
        this.loanResultRepository = loanResultRepository;
        this.creditScoreService = creditScoreService;
        this.customerService = customerService;
        this.customerSMSNotification = customerSMSNotification;
    }


    /**
     * @return Returns all loan result
     */
    @Override
    public List<LoanResultDto> findAll() {
        log.info(CLASS_NAME_LOG + " service findAll method is running.");

        List<LoanResult> loanResultList = loanResultRepository.findAll();
        List<LoanResultDto> loanResultDtoList = LoanResultMapper.INSTANCE.mapFromLoanResultListToLoanResultDto(loanResultList);

        return loanResultDtoList;
    }

    /**
     * @param nationalId  is unique
     * @param dateOfBirth type is Date (YYYY-MM-DD)
     * @return Returns the credit result of the customer whose national identity number and date of birth are registered
     */
    @Override
    public LoanResultDto findByNationalIdNumberAndDateOfBirth(String nationalId, LocalDate dateOfBirth) {
        log.info(CLASS_NAME_LOG + " service findByNationalIdNumberAndDateOfBirth method is running.");

        boolean isCustomerExist = customerService.existsByNationalIdNumberAndDateOfBirthGreaterThan(nationalId, dateOfBirth);

        // National Identity Number or date of birth not found!
        if (!isCustomerExist) {
            log.error(nationalId + ": National Identity Number or " + dateOfBirth + ": date of birth not found!");
            throw new CustomerNotFoundException("National Identity Number or date of birth not found! " + "ID: " + nationalId + ", Date Birth: " + dateOfBirth);
        }

        LoanResultDto loanResultDto = loanResultRepository.findByNationalIdNumber(nationalId);

        // Registered as a customer but no credit debt
        if (loanResultDto == null) {
            log.error("Customer National Id: " + nationalId + ", Credit information not found!");
            throw new CustomerNotFoundException("Customer National Id: " + nationalId + ", Credit information not found!");
        }

        log.info("ID: " + nationalId + ", Date Birth: " + dateOfBirth + " is find customer!");
        return loanResultDto;
    }

    /**
     * Create a new Loan
     *
     * @param loanResultDto is Loan Data-Transfer-Object Model
     * @return The created loan result is returned
     */
    private LoanResultDto save(LoanResultDto loanResultDto) {
        log.info(CLASS_NAME_LOG + " service loanResultDto method is running.");

        LoanResult loanResult = LoanResultMapper.INSTANCE.mapFromLoanResultDtoToLoanResult(loanResultDto);
        loanResult.setCreatedDate(LocalDateTime.now());

        LoanResultDto newLoanResultDto = LoanResultMapper.INSTANCE.mapFromLoanResultToLoanResultDto(loanResultRepository.save(loanResult));

        log.info("Loan result is saved");

        return newLoanResultDto;
    }


    /**
     * Loan Result Calculate For Registered Customer
     *
     * @param nationalId is unique
     * @return Calculates the credit result of the customer registered in the system
     */
    @Override
    public LoanResultDto resultLoanCalculateForRegisteredCustomer(String nationalId) {
        log.info(CLASS_NAME_LOG + " service resultLoanCalculateForRegisteredCustomer method is running.");
        LoanResultDto loanResultDto = new LoanResultDto();
        CustomerDto customerDto = customerService.findByNationalId(nationalId);

        double creditScore = creditScoreService.getCreditScore(customerDto.getNationalIdNumber()).doubleValue();
        double monthlyIncome = customerDto.getMonthlyIncome().doubleValue();
        BigDecimal guarantee = customerDto.getGuarantee();

        // Global loan result calculation method
        loanResultDto = calculateLoanResult(loanResultDto, customerDto, creditScore, monthlyIncome, guarantee);

        log.info("Loan Result is saved.");
        return loanResultDto;
    }

    /**
     * Loan Result Calculate For New Customer
     *
     * @param createCustomerDto is Customer Data-Transfer-Object Model
     * @return Adds new customer to the system and calculates the loan result
     */
    @Override
    public LoanResultDto resultLoanCalculateForNewCustomer(CreateCustomerDto createCustomerDto) {
        log.info(CLASS_NAME_LOG + " service resultLoanCalculateForNewCustomer method is running.");

        LoanResultDto loanResultDto = new LoanResultDto();
        double creditScore = creditScoreService.getCreditScore(createCustomerDto.getNationalIdNumber()).doubleValue();
        double monthlyIncome = createCustomerDto.getMonthlyIncome().doubleValue();
        BigDecimal guarantee = createCustomerDto.getGuarantee();

        CustomerDto customerDto = CustomerMapper.INSTANCE.mapFromCreateCustomerDtoToCustomerDto(createCustomerDto);

        // Global loan result calculation method
        loanResultDto = calculateLoanResult(loanResultDto, customerDto, creditScore, monthlyIncome, guarantee);

        log.info("Loan Result is saved.");
        customerService.save(createCustomerDto);


        return loanResultDto;
    }

    /**
     * Global Loan Result Calculation Method
     *
     * @param loanResultDto is Loan Data-Transfer-Object Model
     * @param customerDto   is Customer Data-Transfer-Object Model
     * @param creditScore   type is Double
     * @param monthlyIncome type is BigDecimal
     * @param guarantee     type is BigDecimal
     * @return Calculates the customer's credit result with the information received from the Credit Score Service
     */
    private LoanResultDto calculateLoanResult(LoanResultDto loanResultDto, CustomerDto customerDto, double creditScore, double monthlyIncome, BigDecimal guarantee) {
        log.info(CLASS_NAME_LOG + " service calculateLoanResult method is running.");
        String smsMessage = "";

        if (creditScore < 500) {
            log.info("Credit Score less than 500 points.");
            loanResultDto.setStatus(LoanStatus.Denied);
            loanResultDto.setCreditLimit(BigDecimal.valueOf(0L));
            log.info("Loan Result is Denied");
        } else if ((creditScore >= 500 && creditScore < 1000) && monthlyIncome <= 5000) {
            log.info("Credit Score between 500 - 1000 and monthly income less than 5000.");
            if (guarantee != null || guarantee.doubleValue() != 0) {
                log.info("10% added to the deposit");
                loanResultDto.setCreditLimit(BigDecimal.valueOf(10000L + guarantee.doubleValue() * 0.1));
            } else {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(10000L));
            }
            loanResultDto.setStatus(LoanStatus.Accepted);
            log.info("Loan Result is Accepted");
        } else if ((creditScore >= 500 && creditScore < 1000) && (monthlyIncome > 5000 && monthlyIncome <= 10000)) {
            log.info("Credit score between 500 - 1000 and Monthly income between 5000 - 10000");
            if (guarantee != null || guarantee.doubleValue() != 0) {
                log.info("20% added to the deposit");
                loanResultDto.setCreditLimit(BigDecimal.valueOf(20000L + guarantee.doubleValue() * 0.2));
            } else {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(20000L));
            }
            loanResultDto.setStatus(LoanStatus.Accepted);
            log.info("Loan Result is Accepted");
        } else if ((creditScore >= 500 && creditScore < 1000) && monthlyIncome > 10000) {
            log.info("Credit score between 500 - 1000 and monthly income greater than 10000");
            if (guarantee != null || guarantee.doubleValue() != 0) {
                log.info("25% added to the deposit");
                loanResultDto.setCreditLimit(
                        BigDecimal.valueOf((monthlyIncome * (CREDIT_LIMIT_FACTOR / 2.0))
                                + guarantee.doubleValue() * 0.25));
            } else {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(monthlyIncome * (CREDIT_LIMIT_FACTOR / 2.0)));
            }
            loanResultDto.setStatus(LoanStatus.Accepted);
            log.info("Loan Result is Accepted");
        } else if (creditScore >= 1000) {
            log.info("Credit score greater than 1000");
            if (guarantee != null || guarantee.doubleValue() != 0) {
                log.info("50% added to the deposit");
                loanResultDto.setCreditLimit(
                        BigDecimal.valueOf((monthlyIncome * CREDIT_LIMIT_FACTOR) + guarantee.doubleValue() * 0.5));
            } else {
                loanResultDto.setCreditLimit(BigDecimal.valueOf(monthlyIncome * CREDIT_LIMIT_FACTOR));
            }
            loanResultDto.setStatus(LoanStatus.Accepted);
            log.info("Loan Result is Accepted");
        }

        loanResultDto.setNationalIdNumber(customerDto.getNationalIdNumber());
        loanResultDto.setCreatedTime(LocalDateTime.now());

        LoanResultDto loanResult = save(loanResultDto);

        log.info("Loan Result is calculated.");

        smsMessage = "Dear " + customerDto.getFullName() + ", Your loan application has been reviewed!"
                + " Loan Result: " + loanResultDto.getStatus() + ", Credit Limit: " + loanResultDto.getCreditLimit()
                + ", Result Date: " + LocalDateTime.now().toString();

        customerSMSNotification.smsSend(customerDto, smsMessage);
        return loanResult;
    }
}

