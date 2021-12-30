package com.webapp.crm.service;

import java.util.List;

import com.webapp.crm.entity.Customer;

public interface CustomerServices {
	
	public List<Customer> getCustomersList();

	public void createNewCustomer(Customer newCustomer);

	public Customer getCustomerByID(int id);

	public void delete(int id);

}
