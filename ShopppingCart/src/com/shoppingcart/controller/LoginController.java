package com.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginController {

	

	@RequestMapping("/login")
	public String showLogin() {
		
		return "login";
	}
	

	@RequestMapping("/logout")
	public String showLogout() {
		
		return "login";
	}
	
	@RequestMapping("/admin")
	public String showAdmin() {
		
		return "admin";
	}
}
