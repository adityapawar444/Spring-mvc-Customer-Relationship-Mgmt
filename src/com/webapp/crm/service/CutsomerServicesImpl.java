package com.webapp.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.crm.dao.CustomerDAO;
import com.webapp.crm.entity.Customer;

@Service
public class CutsomerServicesImpl implements CustomerServices {

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomersList() {
	
		return customerDAO.getCustomers();
	}

}
