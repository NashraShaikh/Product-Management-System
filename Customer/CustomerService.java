package com.product.service;

import com.product.dao.CustomerDao;
import com.product.dto.Customer;

public class CustomerService {
       CustomerDao customerDao=new CustomerDao();
       
     //TO INSERT CUSTOMER DETAILS
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	// TO SHOW ALL CUSTOMER DETAILS	
	public Customer allCustomer(Customer customer) {
		return customerDao.allCustomer(customer);
	}
	
	//TO SHOW CUSTOMER BASED ON NAME
	public Customer getCustomerDetails(Customer customer) {
		return customerDao.getCustomerDetails(customer);
	}
	
	// TO UPDATE PRODUCT DETAILS
	public boolean updateCustomerDetails(int id,String email) {
		return customerDao.updateCustomerDetails(id, email);
	}
	
	//TO DELETE CUSTOMER DETAILS
	public boolean deletCustomertById(int id) {
		return customerDao.deletCustomertById(id);
	}
}
