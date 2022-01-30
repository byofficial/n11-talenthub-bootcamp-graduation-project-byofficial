package com.n11.graduationproject.service.impl;

import com.n11.graduationproject.repository.ICreditScoreRepository;
import com.n11.graduationproject.service.ICreditScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
@Slf4j
public class CreditScoreServiceImpl implements ICreditScoreService {

    private final String CLASS_NAME_LOG = this.getClass().getSimpleName();

    private final ICreditScoreRepository creditScoreRepository;

    @Autowired
    public CreditScoreServiceImpl(ICreditScoreRepository creditScoreRepository) {
        this.creditScoreRepository = creditScoreRepository;
    }

    /**
     * @param nationalId is unique
     * @return Returns results based on the last digit of the customer's national ID number
     */
    @Override
    public BigDecimal getCreditScore(String nationalId) {
        log.info(CLASS_NAME_LOG + " service getCreditScore method is running.");

        BigDecimal creditScore = new BigDecimal(0L);
        int lastDigit = nationalId.charAt(nationalId.length() - 1) - '0';

        switch (lastDigit) {
            case 0:
                creditScore = BigDecimal.valueOf(1000L);
                break;
            case 2:
                creditScore = BigDecimal.valueOf(400L);
                break;
            case 4:
                creditScore = BigDecimal.valueOf(800L);
                break;
            case 6:
                creditScore = BigDecimal.valueOf(650L);
                break;
            case 8:
                creditScore = BigDecimal.valueOf(2000L);
                break;
        }
        
        log.info("Credit score calculated! Credit Score: " + creditScore.doubleValue());
        return creditScore;
    }

}

