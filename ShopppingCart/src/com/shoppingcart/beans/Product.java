package com.shoppingcart.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoppingcart.model.Account;

@Component("Product")
public class Product {

	private int id;
	private String name;
	private String price;
	private String desc;
	private Account account;
	private List <Product>list;
	@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private Vendor vendor;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}

	@Autowired
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public  List<Product> getAllProducts()
	{
		//access Account
		list=account.getAllProducts();
		return list;
	}
	
	public  Product getSingleProduct(int id)
	{
		//access Account
		return account.getSingleProduct(id);
	
	}
}
