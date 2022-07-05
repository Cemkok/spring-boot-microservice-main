package com.Bit.MainService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bit.MainService.service.customer.ICustomerService;
import com.google.gson.JsonElement;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("gateway/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@PostMapping
	public ResponseEntity<?> saveCustomer(@RequestBody JsonElement customer)
	{
		log.info("saveCustomer called ");
		this.internalLogDetail();
		return ResponseEntity.ok(customerService.saveCustomer(customer));
	}
	
	@DeleteMapping("{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customerId)
	{
		log.info("deleteCustomer called ");
		this.internalLogDetail();
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCustomers()
	{
		log.info("getAllCustomers called ");
		this.internalLogDetail();
		
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
	private String internalLogDetail() {
		  try {
			  log.debug("internalLogDetail methodu basladi");
			  Thread.sleep(1000);
			  return "Api Mesaj";
		  } 
		  catch (InterruptedException e ) {
			  log.error("Hata : {}", e);
		  }
		  return "";
	  }
	
	
	
}
