package com.example.demo.auth.authmanger;

import com.example.demo.BankAccount.BankAccount;
import com.example.demo.BankAccount.BankAccountRepository;
import com.example.demo.auth.ApplicationUser;
import com.example.demo.auth.ApplicationUserDao;
import com.example.demo.auth.permissions.ApplicationUserRoles;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.demo.auth.permissions.ApplicationUserRoles.*;

@Repository("dev")
public class ApplicationUserDaoService implements ApplicationUserDao {
    private final BankAccountRepository bankAccountRepository;

    public ApplicationUserDaoService(
            BankAccountRepository bankAccountRepository
    ) {
        this.bankAccountRepository = bankAccountRepository;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String email) {
        BankAccount bankAccount = bankAccountRepository.findByEmail(email);
        if (bankAccount != null) {
            var resp=  Optional.of(new ApplicationUser(
                    bankAccount.getName(),
                    bankAccount.getPassword(),
                    STUDENT.getGrantedAuth(),
                    true,
                    true,
                    true,
                    true
            ));
            System.out.println(resp);
            return resp;
        }
        return Optional.empty();
    }
}
