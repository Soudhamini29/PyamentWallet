package com.cg.paymentapp.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.paymentapp.beans.BankAccount;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.TransactionBean;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exceptions.AccountNotFoundException;
import com.cg.paymentapp.exceptions.CustomerNotFoundException;
import com.cg.paymentapp.exceptions.InsufficientAmountException;
import com.cg.paymentapp.repositories.AccountRepository;
import com.cg.paymentapp.repositories.TransactionRepo;
import com.cg.paymentapp.repositories.UserRepository;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private TransactionRepo transactionRepo;
	
	Logger logger=LoggerFactory.getLogger(WalletServiceImpl.class);
	
	@Override
	public Customer createAccount(Customer customer) {
		
		logger.info("createAccount method of WalletServiceImpl");
		return userRepo.save(customer);
		}
	
		

	@Override
	public BigDecimal showBalance(String mobileNo) {
		
		Customer customer= userRepo.findByMobileNo(mobileNo);
		logger.info("showBalance method of WalletServiceImpl");
		
		if(customer == null)
			throw new CustomerNotFoundException("Customer not found with Mobile number" +mobileNo);
		else
			return customer.getWallet().getBalance();
		
	}

	@Transactional
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {
		
		Customer customer= userRepo.findByMobileNo(mobileNo);
		logger.info("depositAmount method of WalletServiceImpl");
		
		if(customer == null) 
			throw new CustomerNotFoundException("Customer Not found with mobile number"+mobileNo);
		else
		{
			Wallet w= customer.getWallet();
			
			w.setBalance(w.getBalance().add(amount));
			
			customer.setWallet(w);
			
			TransactionBean tr=new TransactionBean();
			tr.setAmount(amount.doubleValue());
			tr.setTransactionType("Amount deposited"+amount);
			tr.setMobileNo(mobileNo);
			tr.setTransactionDate(LocalDate.now());
			tr.setDescription(amount+" Amount Deposited to "+customer.getName()+" wallet");
			
			transactionRepo.save(tr);
			
			
			return userRepo.save(customer);
			
			
		}
		
		
		
		
	}

	@Override
	public List<Customer> getAllCustomerList() {
		
		logger.info("getAllCustomerList method of WalletServiceImpl");
		return userRepo.findAll();
	}

	@Transactional
	@Override
	public Customer addMoneyToWalletFromAccount(String mobileNo, int accno,int amount) {
		
		logger.info("addMoneyToWalletFromAccount method of WalletServiceImpl");
		BankAccount acc= accountRepo.findById(accno).orElseThrow(() -> new AccountNotFoundException("Account not found with given Account number"+accno));
		
		Customer customer= userRepo.findByMobileNo(mobileNo);
		
		if(customer == null)
			throw new CustomerNotFoundException("Customer not found with Mobileno :"+mobileNo);
		

		
		if(acc.getBalance() >= amount) {
			
			acc.setBalance(acc.getBalance()-amount);
			Wallet w=customer.getWallet();
			w.setBalance(w.getBalance().add(BigDecimal.valueOf(amount)));
			
			customer.setWallet(w);
			
			accountRepo.save(acc);
			
			
			
			TransactionBean tr=new TransactionBean();
			tr.setAmount(amount);
			tr.setTransactionType("Amount Transfered "+amount);
			tr.setMobileNo(mobileNo);
			tr.setTransactionDate(LocalDate.now());
			tr.setDescription(amount+" Amount Transfered from Bank to the Wallet ");
			
			transactionRepo.save(tr);
			
			
			return userRepo.save(customer);
			
			
		}
		else
			throw new InsufficientAmountException("Insufficient Balance...");
		
	}

	
	@Transactional
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {
		
		Customer source= userRepo.findByMobileNo(sourceMobileNo);
		Customer target= userRepo.findByMobileNo(targetMobileNo);
		
		logger.info("fundTransfer method of WalletServiceImpl");
		
		if(source == null)
			throw new CustomerNotFoundException("Source Customer Not Found..");
		
		if(target == null)
			throw new CustomerNotFoundException("Target Customer Not Found..");
		
		Wallet swallet= source.getWallet();
		
		if(swallet.getBalance().compareTo(amount) >=0 ) {
			
			Wallet twallet= target.getWallet();
			
			swallet.setBalance(swallet.getBalance().subtract(amount));
			twallet.setBalance(twallet.getBalance().add(amount));
			
			source.setWallet(swallet);
			target.setWallet(twallet);
			
			userRepo.save(target);
		
			
			TransactionBean tr=new TransactionBean();
			tr.setAmount(amount.doubleValue());
			tr.setTransactionType("Amount Transfered "+amount);
			tr.setMobileNo(sourceMobileNo);
			tr.setTransactionDate(LocalDate.now());
			tr.setDescription(amount+" transfered from "+sourceMobileNo +" to the "+targetMobileNo);
			
			transactionRepo.save(tr);
			

			return userRepo.save(source);
			
			
		}
		else
			throw new InsufficientAmountException("Insufficient Amount in Source Wallet");
		
	
	}

	@Override
	public Customer addMoneyToAccountFromWallet(String mobileNo,int accno,BigDecimal amount) {
		
		logger.info("addMoneyToAccountFromWallet method of WalletServiceImpl");
	    BankAccount acc= accountRepo.findById(accno).orElseThrow(() -> new AccountNotFoundException("Account not found with given Account number"+accno));
		
		Customer customer= userRepo.findByMobileNo(mobileNo);
		
		if(customer == null)
			throw new CustomerNotFoundException("Customer not found with Mobileno :"+mobileNo);
		
		 Wallet w=customer.getWallet();
		
		if(w.getBalance().compareTo(amount)>=0) {
			
			w.setBalance(w.getBalance().subtract(amount));
		
			acc.setBalance(acc.getBalance()-amount.doubleValue());
			
			customer.setWallet(w);
			
			accountRepo.save(acc);
			
			
			
			TransactionBean tr=new TransactionBean();
			tr.setAmount(amount.doubleValue());
			tr.setTransactionType("Amount Transfered "+amount);
			tr.setMobileNo(mobileNo);
			tr.setTransactionDate(LocalDate.now());
			tr.setDescription(amount+" Amount Transfered from Wallet to the Bank ");
			
			transactionRepo.save(tr);
			
			
			return userRepo.save(customer);
		
		}
		else
			throw new InsufficientAmountException("Insufficient Balance...");
		
	}
		
	}

	