package com.webapp.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.crm.dao.CustomerDAO;
import com.webapp.crm.entity.Customer;

@Controller
@RequestMapping("customer")
public class CutomerController {

	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping("list")
	public String lisCustomers(Model model) {
		
	List<Customer> resList = customerDAO.getCustomers();	
		
	model.addAttribute("customerList", resList);	
		
		return "customers-list";
	}
}
