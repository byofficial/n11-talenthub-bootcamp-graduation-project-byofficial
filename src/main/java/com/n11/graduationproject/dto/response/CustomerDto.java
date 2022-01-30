package com.n11.graduationproject.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private BigDecimal monthlyIncome;

    private BigDecimal guarantee;

    private String nationalIdNumber;

    private LocalDate dateOfBirth;

    private LocalDateTime createdDate;

    @JsonIgnore
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
