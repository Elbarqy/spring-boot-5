package com.example.demo.BankAccount;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class accountController {
    @PostMapping("login")
    public void login(){
        System.out.println("login");
    }

    @PostMapping("register")
    public void register(){

    }
}
