package com.cg.paymentapp.services;

import java.math.BigDecimal;
import java.util.List;

import com.cg.paymentapp.beans.Customer;

public interface WalletService {
	
	
	public Customer createAccount(Customer customer);

	public BigDecimal showBalance(String mobileNo);
	
	public Customer depositAmount(String mobileNo,BigDecimal amount);
	
	public List<Customer> getAllCustomerList();
	
	public Customer addMoneyToWalletFromAccount(String mobileNo,int accno,int amount);
	
	public Customer addMoneyToAccountFromWallet(String mobileNo,int accno,BigDecimal amount);
	
	public Customer fundTransfer(String sourceMobileNo,String targetMobileNo,BigDecimal amount);
	
}
