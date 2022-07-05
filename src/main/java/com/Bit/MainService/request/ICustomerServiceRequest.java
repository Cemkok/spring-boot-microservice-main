package com.Bit.MainService.request;

import java.util.List;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ICustomerServiceRequest {
	
	@POST("/api/customers")
	Call<JsonElement> saveCustomer(@Body JsonElement requestBody);
	
	@DELETE("/api/customers/{customerId}")
	Call<Void> deleteCustomer(@Path("customerId") int customerId);
	
	@GET("/api/customer")
	Call<List<JsonElement>> getAllCustomers();
	
	@GET("/api/customers/{id}")
	Call<List<JsonElement>> getById();

}
