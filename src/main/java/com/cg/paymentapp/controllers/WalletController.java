package com.cg.paymentapp.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.services.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;
	Logger logger=LoggerFactory.getLogger(WalletController.class);
	
	/*
	{
	    "name": "Rama",
	    "mobileNo": "3232324",
	    "password": "123",
	    "wallet":{
	            "balance":5000
	    }
	}
	*/
	@PostMapping("/createCustomerAccount")
	public Customer createCustomerAccount(@Valid @RequestBody Customer customer) {

		logger.info("createCustomerAccount method of WalletController");
		return walletService.createAccount(customer);		
	}
	
	@GetMapping("/getBalance/{mobileNo}")
	public BigDecimal getCustomerBalance(@PathVariable String mobileNo) {
		
		logger.info("getCustomerBalance method of WalletController");
		return walletService.showBalance(mobileNo);
	}
	
	
	@PutMapping("/depositAmount/{mobileNo}/{amount}")
	public Customer depositAmount(@PathVariable String mobileNo,@PathVariable BigDecimal amount) {
		
		logger.info("depositAmount method of WalletController");
		return walletService.depositAmount(mobileNo, amount);
		
	}
	
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer(){
		
		logger.info("getAllCustomer method of WalletController");
		return walletService.getAllCustomerList();
	}
	
	@PutMapping("/addMoneyFromAccount/{mobileNo}/{accno}/{amount}")
	public Customer addMoneyFromAccount(@PathVariable String mobileNo,
										@PathVariable int accno,
										@PathVariable int amount) {
		
		logger.info("addMoneyFromAccount method of WalletController");
		return walletService.addMoneyToWalletFromAccount(mobileNo, accno, amount);
		

	}
	
	@PutMapping("/addMoneyFromWallet/{mobileNo}/{accno}/{amount}")
	public Customer addMoneyFromWallet(@PathVariable String mobileNo,
										@PathVariable int accno,
										@PathVariable BigDecimal amount) {
		
		logger.info("addMoneyFromWallet method of WalletController");
		return walletService.addMoneyToAccountFromWallet(mobileNo, accno, amount);
		

	}
	
	@PutMapping("/transferAmount/{sourceMobileNo}/{targetMobileNo}/{amount}")
	public Customer transferFund(@PathVariable String sourceMobileNo,
								@PathVariable String targetMobileNo,
								@PathVariable BigDecimal amount) {
		
		logger.info("transferFund method of WalletController");
		return walletService.fundTransfer(sourceMobileNo, targetMobileNo, amount);
		
		
		
	}
	
	
	
	
	
	
	
	
}
