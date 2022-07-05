package com.Bit.MainService.service.customer;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bit.MainService.request.ICustomerServiceRequest;
import com.Bit.MainService.util.RetrofitUtils;
import com.google.gson.JsonElement;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

@Slf4j
@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerServiceRequest customerServiceRequest;

	
	@Override
	public JsonElement saveCustomer(JsonElement requestBody) {
		
		return RetrofitUtils.executeInBlock(customerServiceRequest.saveCustomer(requestBody));
		
	}
	
	
	@Override
	public void deleteCustomer(int customerId)
	{
		RetrofitUtils.executeInBlock(customerServiceRequest.deleteCustomer(customerId));
	}
	

	@Override
	public List<JsonElement> getAllCustomers()
	{
		System.out.println("ben çalıştım");
	return RetrofitUtils.executeInBlock(customerServiceRequest.getAllCustomers());
	}
}
