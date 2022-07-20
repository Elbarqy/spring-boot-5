package com.example.demo.BankAccount;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class accountController {

    private final BankAccountService bankAccountService;

    public accountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("login")
    public void login() {
        System.out.println("login");
    }

    @PostMapping("register")
    public ResponseEntity<BankAccount> newAccount(@RequestBody BankAccount bankAccount) {
        return new ResponseEntity<>(bankAccountService.createNewAccount(bankAccount), HttpStatus.CREATED);
    }
}
