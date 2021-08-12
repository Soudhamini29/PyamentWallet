package com.cg.paymentapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.services.BankAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	Logger logger=LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private BankAccountService bankService;
	
	
	/*
	 *  {
        "ifscCode": "sbiifsc",
        "bankName": "sbi",
        "balance": 60000.0
    }
	 * 
	 * 
	 */
	@PostMapping("/createAccount")
	public BankAccount createAccount(@RequestBody BankAccount account) {
		
		
	
		logger.info("CreateAccount method of AccountController");
				
		return bankService.addAccount(account);
	}
	
	@GetMapping("/getAllAccounts")
	public List<BankAccount> getAllBankAccounts(){
		
		logger.info(" GetAllAccounts method of AccountController");
		return bankService.viewAllBankAccounts();
	}
	
	@GetMapping("/getAccount/{accno}")
	public BankAccount getAccountByAccountNumber(@PathVariable int accno) {
		
		logger.info("GetAccountByAccountNumber method of AccountController");
		return bankService.viewAccount(accno);
	}
	
	
	@DeleteMapping("/deleteAccount/{accno}")
	public BankAccount deleteAccount(@PathVariable int accno) {
		
		logger.info("DeleteAccount method of AccountController");
		return bankService.removeBankAccount(accno);
	}
	
	
	
	
	
	
	
}
