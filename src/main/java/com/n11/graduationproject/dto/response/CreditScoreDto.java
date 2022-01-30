package com.n11.graduationproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreditScoreDto {

    private String nationalIdNumber;

    private BigDecimal score;

    private LocalDateTime createdDate;
}
