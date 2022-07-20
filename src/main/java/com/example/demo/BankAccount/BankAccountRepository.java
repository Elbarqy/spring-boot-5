package com.example.demo.BankAccount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    List<BankAccount> findByName(String name);

    @Query("select acc from BANK_ACCOUNT acc where acc.name= :name")
    Stream<BankAccount> findByNameReturnStream(@Param("name") String name);
}
