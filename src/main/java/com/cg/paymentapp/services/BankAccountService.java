package com.cg.paymentapp.services;

import java.util.List;

import com.cg.paymentapp.beans.BankAccount;

public interface BankAccountService {
	
	public BankAccount addAccount(BankAccount bankAccount);
	
	public BankAccount removeBankAccount(int accno);
	
	public BankAccount viewAccount(int accno);
	
	public List<BankAccount> viewAllBankAccounts();

}
