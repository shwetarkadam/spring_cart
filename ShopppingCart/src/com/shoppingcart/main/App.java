package com.shoppingcart.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppingcart.beans.Product;

public class App {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/shoppingcart/main/Beans.xml") ; 
		Product p=(Product)context.getBean("Product");
		//Product p1=(Product)context.getBean("Product"); when singleton same object will be retruned of p 
		//if prototype is selected different objects will be retured DONOT DO THIS DONT EXHAUST HEAP MEMORY
		/*
		 
		 System.out.println(p==p1);
		 */
	//System.out.println(p);
	
	/*List <Product>list=p.getAllProducts();
	for(Product p1:list) {
		System.out.println("\t"+p1.getId()+"\t"+p1.getName()+"\t"+p1.getDesc()+"\t"+p1.getPrice());
	}
	*/
	p=p.getSingleProduct(2);
	System.out.println(p);
		((ClassPathXmlApplicationContext)context).close();

	}

}
