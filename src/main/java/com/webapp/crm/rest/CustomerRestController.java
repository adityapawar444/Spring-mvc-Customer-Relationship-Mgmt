package com.webapp.crm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.crm.entity.Customer;
import com.webapp.crm.rest.exceptions.CustomerNotFoundException;
import com.webapp.crm.service.CustomerServices;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

	@Autowired
	CustomerServices customerServices;

	@GetMapping("list")
	public List<Customer> lisCustomers() {

		List<Customer> resList = customerServices.getCustomersList();

		return resList;
	}
	
	@GetMapping("customer/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		
		Customer customer = customerServices.getCustomerByID(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer id not found : " + customerId);
		}
		
		return customer;
	}

}
