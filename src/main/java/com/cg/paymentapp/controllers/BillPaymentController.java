package com.cg.paymentapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.beans.BillPayment;
import com.cg.paymentapp.beans.BillType;
import com.cg.paymentapp.services.BillPaymentService;

@RestController
@RequestMapping("/bill")
public class BillPaymentController {

	@Autowired
	private BillPaymentService billService;
	
	Logger logger=LoggerFactory.getLogger(BillPaymentController.class);
	
	
	//http://localhost:8000/bill/payTheBill/3232325/GAS/700
	
	@PostMapping("/payTheBill/{mobileNo}/{billType}/{amount}")
	public BillPayment payTheBill(@PathVariable String mobileNo,
								@PathVariable BillType billType,
								@PathVariable double amount) {
		
		logger.info("addbill method of BillPaymentController");
		
		return billService.payTheBill(mobileNo,billType , amount);
		
		
		
	}
	
	@GetMapping("/getAllBillsForCustomer/{mobileNo}")
	public List<BillPayment> getAllBillPayementForCustomer(@PathVariable String mobileNo){
		
		logger.info("viewallbills method of BillPayementController");
		return billService.getTheBillPaymentOfCustomer(mobileNo);
	}
	
	
	
	
}
