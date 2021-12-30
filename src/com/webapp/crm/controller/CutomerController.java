package com.webapp.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.crm.dao.CustomerDAO;
import com.webapp.crm.entity.Customer;
import com.webapp.crm.service.CustomerServices;

@Controller
@RequestMapping("customer")
public class CutomerController {

	@Autowired
	CustomerServices customerServices;

	@GetMapping("list")
	public String lisCustomers(Model model) {

		List<Customer> resList = customerServices.getCustomersList();

		model.addAttribute("customerList", resList);

		return "customers-list";
	}

	@GetMapping("addCustomerForm")
	public String addCustomerForm(Model model) {

		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "add-customer";
	}

	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer newCustomer) {

		customerServices.createNewCustomer(newCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {

		Customer customer = customerServices.getCustomerByID(id);

		model.addAttribute("customer", customer);

		return "add-customer";
	}

	@GetMapping("delete")

	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		customerServices.delete(id);

		return "redirect:/customer/list";
	}

}
