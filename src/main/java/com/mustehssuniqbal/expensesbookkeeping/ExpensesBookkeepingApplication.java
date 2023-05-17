package com.mustehssuniqbal.expensesbookkeeping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.mustehssuniqbal")
@EntityScan("com.mustehssuniqbal")
public class ExpensesBookkeepingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensesBookkeepingApplication.class, args);
	}

}
