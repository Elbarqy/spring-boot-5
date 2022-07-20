package com.example.demo.BankAccount;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.aliasing.qual.Unique;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "BANK_ACCOUNT")
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Name is a mandatory field")
    private String name;
    @Column(name = "email")
    private String email;
    private String password;
    private String role = "STUDENT";
    @Column(name = "CREATED_AT",updatable = false)
    @CreatedDate
    Date created_at = new Date();
    @Column(name = "MODIFIED_AT",updatable = false)
    @LastModifiedDate
    Date modified_at;
}

//@Builder
