package com.example.demo.BankAccount;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "BANK_ACCOUNT")
@Data
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    @Column(name = "CREATED_AT")
    Date created_at;
}

//@Builder
