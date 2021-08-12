package com.cg.paymentapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.exceptions.AccountNotFoundException;
import com.cg.paymentapp.repositories.AccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	private AccountRepository accountRepo;
	Logger logger=LoggerFactory.getLogger(BankAccountServiceImpl.class);
	
	
	@Override
	public BankAccount addAccount(BankAccount bankAccount) {
		
		logger.info("addAccount method of BankAccountServiceImpl");
		return accountRepo.save(bankAccount);
	}

	@Override
	public BankAccount removeBankAccount(int accno) {
		
		
		BankAccount account= accountRepo.findById(accno).orElseThrow(()-> new AccountNotFoundException("Account does not exist") );
		
		accountRepo.delete(account);
		logger.info("removeAccount method of BankAccountServiceImpl");

		return account;
		
		
	}

	@Override
	public BankAccount viewAccount(int accno) {
		
		//System.out.println(accno);
		logger.info("viewAccount method of BankAccountServiceImpl");
		
	 	return accountRepo.findById(accno).orElseThrow(() -> new AccountNotFoundException("Account does not exist"));
		
	}

	@Override
	public List<BankAccount> viewAllBankAccounts() {
		
		logger.info(" viewAllBankAccounts method of BankAccountServiceImpl");
		return accountRepo.findAll();
	}

}
