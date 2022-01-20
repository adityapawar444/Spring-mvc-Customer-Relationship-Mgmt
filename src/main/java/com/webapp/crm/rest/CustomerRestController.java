package com.webapp.crm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.crm.entity.Customer;
import com.webapp.crm.rest.exceptions.CustomerNotFoundException;
import com.webapp.crm.service.CustomerServices;

@RestController
@RequestMapping("api/")
public class CustomerRestController {

	@Autowired
	CustomerServices customerServices;

	@GetMapping("customers")
	public List<Customer> lisCustomers() {

		List<Customer> resList = customerServices.getCustomersList();

		return resList;
	}

	@GetMapping("customers/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {

		Customer customer = customerServices.getCustomerByID(customerId);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found : " + customerId);
		}

		return customer;
	}

	@PostMapping("customers")
	public Customer addCutsomer(@RequestBody Customer newCustomer) {

		newCustomer.setId(0);

		customerServices.createNewCustomer(newCustomer);

		return newCustomer;

	}
	
	@PutMapping("customers")
	public Customer updateCutsomer(@RequestBody Customer newCustomer) {

		newCustomer.setId(0);

		customerServices.createNewCustomer(newCustomer);

		return newCustomer;

	}
	
	@DeleteMapping("customers/{customerId}")
	public String deletCUstomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerServices.getCustomerByID(customerId);
		
		if(tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found : " + customerId);
		}
		
		customerServices.delete(customerId);
		
		return "Deleted Customer with ID : " + customerId;
	}

}
