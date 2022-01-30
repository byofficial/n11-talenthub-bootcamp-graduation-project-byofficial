package com.n11.graduationproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document("credit_scores")
public class CreditScore {
    @Id
    private String id;

    @Indexed(unique = true)
    private String nationalIdNumber;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal score;

    @CreatedDate
    private LocalDateTime createdDate;
}
