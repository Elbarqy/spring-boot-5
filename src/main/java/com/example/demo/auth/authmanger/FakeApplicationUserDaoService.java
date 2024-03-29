package com.example.demo.auth.authmanger;

import com.example.demo.auth.ApplicationUser;
import com.example.demo.auth.ApplicationUserDao;
import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.demo.auth.permissions.ApplicationUserRoles.ADMIN;
import static com.example.demo.auth.permissions.ApplicationUserRoles.STUDENT;


@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(
                        "test",
                        passwordEncoder.encode("test"),
                        STUDENT.getGrantedAuth(),
                        true,
                        true,
                        true,
                        true
                ), new ApplicationUser(
                        "admin",
                        passwordEncoder.encode("admin"),
                        ADMIN.getGrantedAuth(),
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
