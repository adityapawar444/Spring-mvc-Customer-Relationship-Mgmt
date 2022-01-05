package com.webapp.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("login")
	public String showLoginPage() {
		return "login-form";
	}
	
	@GetMapping("access-denied")
	public String showAccessDeniedPage() {
		return "access-denied";
	}

}
