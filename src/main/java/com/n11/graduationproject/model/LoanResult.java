package com.n11.graduationproject.model;

import com.n11.graduationproject.model.enums.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("loan_results")
public class LoanResult {
    @Id
    private String id;

    @Indexed(unique = true)
    private String nationalIdNumber;

    private LoanStatus status;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal creditLimit;

    @CreatedDate
    private LocalDateTime createdDate;
}
