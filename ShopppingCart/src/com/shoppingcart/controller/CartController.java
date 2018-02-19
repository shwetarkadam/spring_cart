package com.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shoppingcart.beans.Product;
import com.shoppingcart.beans.Vendor;

@Controller
public class CartController {

private	Product product;
private Vendor vendor;
	@Autowired
	public void setVendor(Vendor vendor) {
	this.vendor = vendor;
}

	@Autowired
	public void setProduct(Product product) {
	this.product = product;
}

	@RequestMapping("/")
	public String showHome(HttpSession session,Model model) {
		session.setAttribute("email", "shwetakadam@gmail.com");//for using session scope
		model.addAttribute("name","Shweta");//for using model/request scope
		return "index";
	}
	
	@RequestMapping(value="/Show-All-Products")
	public String showAllProducts(HttpSession session) {
		List<Product>list=product.getAllProducts();
		session.setAttribute("list", list);
		return "products";
	}
	
	@RequestMapping(value="/Show-Product")
	public String showProduct(Model model,@RequestParam("id") String id) {
		model.addAttribute("id", id);
		
		return "product_desc";
	}
	
	@RequestMapping(value="/vendor-register",method=RequestMethod.POST)
	public String doRegister(Model model,@Valid Vendor v,BindingResult result) {
		if(result.hasErrors()) {
			return "vendor_register";
		}
		
		//model.addAttribute("name", v.getName());
		//model.addAttribute("city", v.getCity());
		v.setEnabled("true");
		v.setAuthority("vendor");
		vendor.createVendor(v);
		return "register_success";
	}
	
	@RequestMapping(value="/Vendor-Registration")
	public String reqRegister(Model model) {
		model.addAttribute("vendor", new Vendor());
		
		return "vendor_register";
	}

	
	
	@RequestMapping("/Add-Product")
	public String addProduct(Model model) {

		
		return "add_product";
	}
}
