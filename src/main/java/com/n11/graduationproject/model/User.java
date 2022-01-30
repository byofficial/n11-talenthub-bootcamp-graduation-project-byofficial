package com.n11.graduationproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;

    @CreatedDate
    private LocalDateTime createdDate;
}

