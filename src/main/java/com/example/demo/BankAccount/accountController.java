package com.example.demo.BankAccount;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class accountController {
    private final PasswordEncoder encoder;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public accountController(PasswordEncoder encoder, BankAccountRepository bankAccountRepository) {
        this.encoder = encoder;
        this.bankAccountRepository = bankAccountRepository;
    }

    @PostMapping("login")
    public void login() {
        System.out.println("login");
    }

    @PostMapping("register")
    public ResponseEntity<BankAccount> newAccount(@RequestBody BankAccount bankAccount) {
        BankAccount newBankAccount = bankAccountRepository.save(bankAccount);
        System.out.println(bankAccount);
        System.out.println(newBankAccount);
        return new ResponseEntity<>(newBankAccount, HttpStatus.CREATED);
    }
}
