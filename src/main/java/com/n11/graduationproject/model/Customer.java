package com.n11.graduationproject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("customers")
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal monthlyIncome;

    @Field(name = "guarantee")
    private BigDecimal guarantee;

    @Indexed(unique = true)
    private String nationalIdNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @Field(name = "date_birth")
    @JsonFormat(pattern = "yyyy/mm/dd")
    private LocalDate dateOfBirth;

    @CreatedDate
    private LocalDateTime createdDate;
}

