package com.cg.paymentapp.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.BillType;
import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.TransactionBean;
import com.cg.paymentapp.beans.Wallet;
import com.cg.paymentapp.exceptions.CustomerNotFoundException;
import com.cg.paymentapp.exceptions.InsufficientAmountException;
import com.cg.paymentapp.repositories.BillRepository;
import com.cg.paymentapp.repositories.TransactionRepo;
import com.cg.paymentapp.repositories.UserRepository;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BillRepository billRepo;
	
	@Autowired
	private TransactionRepo transactionRepo;
	Logger logger=LoggerFactory.getLogger(BillPaymentServiceImpl.class);
	
	@Transactional
	@Override
	public BillPayment payTheBill(String mobileNo, BillType billType,double amount) {
		
		Customer customer = userRepo.findByMobileNo(mobileNo);		
		
		logger.info("payTheBill method of BillPaymentServiceImpl");
		if(customer == null)
			throw new CustomerNotFoundException("Customer not found with Mobile number :"+mobileNo);
		
		Wallet w= customer.getWallet();
		
		if(w.getBalance().compareTo(BigDecimal.valueOf(amount)) >= 0)
		{
		
			w.setBalance(w.getBalance().subtract(BigDecimal.valueOf(amount)));
			
			customer.setWallet(w);
			
			
		BillPayment bill=new BillPayment();
		bill.setBillType(billType);
		bill.setAmount(amount);
		bill.setPaymentDate(LocalDate.now());
		bill.setMobileNo(mobileNo);
			
		userRepo.save(customer);
		
		TransactionBean tr=new TransactionBean();
		tr.setTransactionType("Bill Payment for "+billType.toString());
		tr.setAmount(amount);
		tr.setMobileNo(mobileNo);
		tr.setTransactionDate(LocalDate.now());
		tr.setDescription("Bill Payment dome for "+billType.toString());
		
		transactionRepo.save(tr);
	
		
 	    return billRepo.save(bill);
		}
		else
			throw new InsufficientAmountException("Insufficient amount in the wallet to pay the bill");
			
			
	}


	
	@Override
	public List<BillPayment> getTheBillPaymentOfCustomer(String mobileNo) {
		
		logger.info("getTheBillPaymentOfCustomer method of BillPaymentServiceImpl");
		return billRepo.findByMobileNo(mobileNo);
		
	}



}
