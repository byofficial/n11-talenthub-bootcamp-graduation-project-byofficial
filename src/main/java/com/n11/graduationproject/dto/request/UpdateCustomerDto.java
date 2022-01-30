package com.n11.graduationproject.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerDto {

    @ApiModelProperty(example = "Your First Name must be length between 3 and 30 characters and only letters.")
    @NotBlank(message = "Firstname field cannot be empty!")
    @Size(min = 3, max = 20, message = "First name must be length between 3 and 30 characters.")
    private String firstName;

    @ApiModelProperty(example = "Your Last Name must be length between 3 and 30 characters and only letters.")
    @NotBlank(message = "Lastname field cannot be empty!")
    @Size(min = 3, max = 20, message = "Last Name must be length between 3 and 30 characters.")
    private String lastName;

    @ApiModelProperty(example = "Your Phone Number must be 11 characters and only numbers. (05367788099)")
    @NotBlank(message = "PhoneNumber field cannot be empty!")
    @Pattern(regexp ="[0-9\\s]{11}")
    private String phoneNumber;

    @ApiModelProperty(example = "Your Monthly Income. It can be an integer or a decimal number. Example -> 4650.50")
    @NotNull(message = "monthlyIncome field cannot be empty!")
    @Min(value=0, message = "Monthly income must be greater than 0")
    private BigDecimal monthlyIncome;

    @ApiModelProperty(example = "Your Guarantee. Guarantee value is not mandatory! (Optional)")
    private BigDecimal guarantee;

    @ApiModelProperty(example = "Your Birthday. Date Format: YYYY-MM-DD")
    @NotNull(message = "dateOfBirth field cannot be empty!")
    @Past
    private LocalDate dateOfBirth;

}
