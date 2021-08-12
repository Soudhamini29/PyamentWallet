package com.cg.paymentapp.services;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.beans.TransactionBean;
import com.cg.paymentapp.exceptions.NoTransactionFoundException;
import com.cg.paymentapp.repositories.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepo transactionRepo;
	
	Logger logger=LoggerFactory.getLogger(TransactionServiceImpl.class);
	
	@Override
	public List<TransactionBean> viewAllTransactionForCustomer(String mobileNo) {
		
		List<TransactionBean> list= transactionRepo.findByMobileNo(mobileNo);
		logger.info("viewAllTransactionForCustomer method of TransactionServiceImpl");
				
		if(list.size() ==0)
			throw new NoTransactionFoundException("No transaction found for the mobile number "+mobileNo);
		
		return list;
		
		
	}

	@Override
	public List<TransactionBean> viewTransactionForCustomerByDate(LocalDate startDate, LocalDate endDate) {
		
		logger.info(" viewTransactionForCustomerByDate method of TransactionServiceImpl");
		return transactionRepo.findByTransactionDateBetween(startDate, endDate);
		
	}

	@Override
	public TransactionBean viewTheTransactionById(int txId) {
		
		logger.info("viewTheTransactionById  method of TransactionServiceImpl");	
	return transactionRepo.findById(txId).orElseThrow(() -> new NoTransactionFoundException("Invalid Transaction Ids"));
		
		
	}

}
