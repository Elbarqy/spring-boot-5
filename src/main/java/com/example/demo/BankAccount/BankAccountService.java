package com.example.demo.BankAccount;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    private final PasswordEncoder passwordEncoder;
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(PasswordEncoder encoder, BankAccountRepository bankAccountRepository) {
        this.passwordEncoder = encoder;
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount createNewAccount(BankAccount bankAccount) {
        bankAccount.setPassword(passwordEncoder.encode(bankAccount.getPassword()));
        return bankAccountRepository.save(bankAccount);
    }
}
