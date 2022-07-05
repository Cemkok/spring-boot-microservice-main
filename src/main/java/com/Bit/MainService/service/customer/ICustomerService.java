package com.Bit.MainService.service.customer;

import java.util.List;

import com.google.gson.JsonElement;

public interface ICustomerService {

	JsonElement saveCustomer(JsonElement requestBody);

	void deleteCustomer(int customerId);

	List<JsonElement> getAllCustomers();

}
