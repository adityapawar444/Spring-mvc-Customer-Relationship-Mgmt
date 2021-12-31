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

	@Override
	@Transactional
	public void createNewCustomer(Customer newCustomer) {
		customerDAO.saveCustomer(newCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerByID(int id) {
		return customerDAO.getCustomerByID(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerDAO.deleteById(id);
	}

	@Override
	@Transactional
	public List<Customer> searchName(String queryName) {
		return customerDAO.getCustomerByName(queryName);
	}

}
