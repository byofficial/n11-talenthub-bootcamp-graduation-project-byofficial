package com.n11.graduationproject.dto.response;

import com.n11.graduationproject.model.enums.LoanStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResultDto {

    @ApiModelProperty(example = "National Identity Number. 11 characters and only numbers.")
    @NotBlank(message = "nationalIdNumber field cannot be empty!")
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$")
    private String nationalIdNumber;

    @ApiModelProperty(example = "LoanStatus Accepted or Denied.")
    @NotNull(message = "status field cannot be empty!")
    private LoanStatus status;

    @ApiModelProperty(example = "Credit Limit")
    @NotNull(message = "creditLimit field cannot be empty!")
    private BigDecimal creditLimit;

    @ApiModelProperty(example = "Loan Result Request Date and Time")
    @PastOrPresent
    private LocalDateTime createdTime;
}