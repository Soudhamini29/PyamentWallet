package com.cg.paymentapp.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.TransactionBean;
import com.cg.paymentapp.services.TransactionService;

@RestController
@RequestMapping("/txn")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	Logger logger=LoggerFactory.getLogger(TransactionController.class);
	
	
	@GetMapping("/getAllTransactions/{mobileNo}")
	public List<TransactionBean> getAllTheTransactionForCustomer(@PathVariable String mobileNo){
		
		logger.info("getAllTheTransactionForCustomer of TransactionController");
		return transactionService.viewAllTransactionForCustomer(mobileNo);
	}
	
	
	@GetMapping("getTransactionById/{txId}")
	public TransactionBean getTransactionById(@PathVariable int txId) {
		
		logger.info("getTransactionById method of TransactionController");
		return transactionService.viewTheTransactionById(txId);
	}
	
	@GetMapping("/getTransactionBetweenDates/{sdate}/{edate}")
	public List<TransactionBean> getAllTransactionsBetweenDates(
									@PathVariable String sdate,
									@PathVariable String edate){
		
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate ssdate  =LocalDate.parse(sdate,dtf);
		LocalDate eedate  =LocalDate.parse(edate,dtf);
		
		logger.info("getTransactionBetweenDates method of TransactionController");
		return transactionService.viewTransactionForCustomerByDate(ssdate, eedate);
		
	}
	
	
	
	
}
