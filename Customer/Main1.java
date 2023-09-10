package com.product.controller;

import java.util.Scanner;

import com.product.dto.Customer;
import com.product.service.CustomerService;

public class Main1 {

	public static void main(String[] args) {
		int id;
		String name;
		String email;
		
		Customer customer=new Customer();
        System.out.println("CUSTOMER DETAILS");
		
		Scanner sc = new Scanner(System.in);
		
			System.out.println("1. Add New Customer");
			System.out.println("2. Show All Customer");
			System.out.println("3. Show Customer Details Based On Name");
			System.out.println("4. Update Customer Details");
			System.out.println("5. Delete Customer Details");
			
			System.out.println("Enter a choice: ");
			int ch=sc.nextInt();
			
			switch(ch) {
			
			//TO INSERT PRODUCT DETAILS
			case 1:
				CustomerService c1=new CustomerService();

				System.out.println("Enter customer ID: ");
				id=sc.nextInt();
				
				System.out.println("Enter customer name: ");
				name=sc.next();
				
				System.out.println("Enter customer email: ");
				email=sc.next();
				
				customer.setCustomer_id(id);
				customer.setCustomer_name(name);
				customer.setCustomer_email(email);
				
				Customer c=c1.saveCustomer(customer);
				System.out.println(c.getCustomer_id() +" customer details saved successfully");
            break;
            
            // TO SHOW ALL CUSTOMER DETAILS	
			case 2: 
				CustomerService c2=new CustomerService();
				c2.allCustomer(customer);
			break;
			
			//TO SHOW CUSTOMER BASED ON NAME
			case 3:
				CustomerService c3=new CustomerService();
				System.out.println("Enter customer name: ");
				name=sc.next();
				customer.setCustomer_name(name);
				c3.getCustomerDetails(customer); 
			break;	
			
			// TO UPDATE PRODUCT DETAILS
			case 4:
				CustomerService c4=new CustomerService();
				
				System.out.println("Enter customer id: ");
				id=sc.nextInt();
				customer.setCustomer_id(id);
				
				System.out.println("Enter customer email: ");
				email=sc.next();
				customer.setCustomer_email(email);
				
				c4.updateCustomerDetails(id, email);
				
			break;	
			
			//TO DELETE CUSTOMER DETAILS
			case 5:
				CustomerService c5=new CustomerService();
				
				System.out.println("Enter customer id: ");
				id=sc.nextInt();
				customer.setCustomer_id(id);
				
				c5.deletCustomertById(id);
			break;	
			
			default:
				System.out.println("....Enter vaild Choice....");
			}
			System.out.println("======================================");
	}

}
