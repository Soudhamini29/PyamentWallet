package com.cg.paymentapp.controllers;

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

import com.cg.paymentapp.beans.Customer;
import com.cg.paymentapp.beans.LoginBean;
import com.cg.paymentapp.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	
	/*
	 * 
	  {
    "mobileNo": "3232324",
    "password": "123"
  
		}
	 * 
	 * 
	 */
	
	@PostMapping("/loginUser")
	public Customer validateUser(@RequestBody LoginBean loginBean) {
		
		logger.info("loginUser method of UserController");
		return userService.validateLogin(loginBean.getMobileNo(), loginBean.getPassword());
		
	}
	
	@GetMapping("/getCustomer/{mobileNo}")
	public Customer getCustomerByMobileNumber(@PathVariable String mobileNo) {
		
		logger.info("getCustomer method of UserController");
		return userService.viewCustomerByMobileNo(mobileNo);
	}
	
	@DeleteMapping("/deleteCustomer/{mobileNo}")
	public Customer deleteCustomer(@PathVariable String mobileNo) {
		
		logger.info("deleteCustomer method of UserController");
		return userService.deleteCustomerByMobileNo(mobileNo);
	}
	
	
	
	
}
