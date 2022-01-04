package com.webapp.crm.dao;

import java.util.List;

import com.webapp.crm.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer newCustomer);

	public Customer getCustomerByID(int id);

	public void deleteById(int id);

	public List<Customer> getCustomerByName(String queryName);
	
}
