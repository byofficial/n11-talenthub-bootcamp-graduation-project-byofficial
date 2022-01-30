package com.n11.graduationproject.service;

import java.math.BigDecimal;

public interface ICreditScoreService {
    BigDecimal getCreditScore(String nationalId);
}
