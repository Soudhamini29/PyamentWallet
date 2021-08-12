package com.cg;

import java.math.BigDecimal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.services.BankAccountServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class PaymentwalletapplicationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(PaymentwalletapplicationApplication.class, args);
		
		/*
		 * BankAccountServiceImpl ser=
		 * ctx.getBean("bankAccountServiceImpl",BankAccountServiceImpl.class);
		 * 
		 * 
		 * BankAccount acc=new BankAccount(); acc.setBalance(60000);
		 * acc.setBankName("sbi"); acc.setIfscCode("sbiifsc");
		 * 
		 * Wallet w=new Wallet(); w.setBalance(BigDecimal.valueOf(1000));
		 * 
		 * acc.getWallets().add(w);
		 * 
		 * BankAccount bacc= ser.addAccount(acc);
		 * 
		 * System.out.println(bacc.getAccountNo());
		 * 
		 */
		
		
		
		
	}

}
