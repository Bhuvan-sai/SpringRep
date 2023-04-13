package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.AccountsDAO;
import com.model.AccountsDTO;
import com.model.InsufficientBalance;
import com.model.MyService;
import com.model.TransactionService;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})
public class SecondApplication {

	public static void main(String[] args) throws InsufficientBalance {
		ConfigurableApplicationContext ctx=SpringApplication.run(SecondApplication.class, args);
		
		
		MyService myservice = ctx.getBean("myService",MyService.class);
		myservice.doServe(1,52000);
		
		TransactionService ts = ctx.getBean("tss",TransactionService.class);
		ts.moneyTransfer(1,2,10);
	}
}