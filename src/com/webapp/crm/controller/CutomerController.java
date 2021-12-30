package com.webapp.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.crm.dao.CustomerDAO;
import com.webapp.crm.entity.Customer;
import com.webapp.crm.service.CustomerServices;

@Controller
@RequestMapping("customer")
public class CutomerController {

	@Autowired
	CustomerServices customerServices;
	
	@RequestMapping("list")
	public String lisCustomers(Model model) {
		
	List<Customer> resList = customerServices.getCustomersList();	
		
	model.addAttribute("customerList", resList);	
		
		return "customers-list";
	}
}
