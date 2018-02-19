package com.shoppingcart.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoppingcart.model.Account;

@Component("Vendor")
public class Vendor {

	@NotNull
	@Pattern(regexp="\\w+",message="PLease Enter Name")
private String name;

@Size(min=4,max=10,message="City name must be between 4 and 10 charcters")
private String city;

@NotNull
@Pattern(regexp="\\w+\\@\\w+\\.\\w+",message="PLease Enter Valid email")
private String email;

@Size(min=4,max=20,message="Password name must be between 4 and 10 charcters")
private String password;

private String enabled;

private String authority;

private Account account;
@Autowired
public void setAccount(Account account) {
	this.account = account;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEnabled() {
	return enabled;
}
public void setEnabled(String enabled) {
	this.enabled = enabled;
}
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}
@Override
public String toString() {
	return "Vendor [name=" + name + ", city=" + city + "]";
}
public void createVendor(Vendor v) {
	
	account.createVendor(v);
}
}
