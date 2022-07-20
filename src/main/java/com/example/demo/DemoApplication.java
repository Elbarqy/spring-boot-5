package com.example.demo;

import com.example.demo.BankAccount.BankAccount;
import com.example.demo.BankAccount.BankAccountRepository;
import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication implements CommandLineRunner {
	DataSource dataSource;

	@Autowired
	BankAccountRepository bankAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Transactional(readOnly=true)
	@Override
	public void run(String... args) throws Exception {

//		System.out.println("DATASOURCE = " + dataSource);
//
//		System.out.println("\n1.findAll()...");
//		for (BankAccount customer : bankAccountRepository.findAll()) {
//			System.out.println(customer);
//		}
//
//
//
////		 For Stream, need @Transactional
//		System.out.println("find by stream \n");
//		try (Stream<BankAccount> stream = bankAccountRepository.findByNameReturnStream("ahmed")) {
//			stream.forEach(System.out::println);
//		}
//		System.out.println("Done!");
	}
}
