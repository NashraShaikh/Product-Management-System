package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product.configuration.HelperClass;
import com.product.dto.Customer;
import com.product.dto.Product;

public class CustomerDao {

	HelperClass helperClass=new HelperClass();
	Connection connection=null;
	
	//TO INSERT CUSTOMER DETAILS
	public Customer saveCustomer(Customer customer) {
		connection = helperClass.getConnection();
		String sql="INSERT INTO customer VALUES(?,?,?)";
		
		try {
			//CREATE STATEMENT
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//PASSED THE VALUES TO DELIMITERS/PLACEHOLDERS
			preparedStatement.setInt(1,customer.getCustomer_id());
			preparedStatement.setString(2,customer.getCustomer_name());
			preparedStatement.setString(3,customer.getCustomer_email());
			
			//EXECUTE
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//CLOSE CONNECTION
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}
	
	// TO SHOW ALL CUSTOMER DETAILS	
	public Customer allCustomer(Customer customer) {
		connection = helperClass.getConnection();
		String sql= "SELECT * from customer";
		try {
			//CREATE STATEMENT
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			//EXECUTE STATEMENT
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("================");
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//CLOSE STATEMENT
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return customer;
  }
	
	//TO SHOW CUSTOMER BASED ON NAME
	public Customer getCustomerDetails(Customer customer) {
		connection = helperClass.getConnection();
		String sql= "SELECT * FROM customer WHERE customer_name = ?";
		
		try {
			//CREATE STATEMENT
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//PASSED THE VALUES TO DELIMITERS/PLACEHOLDERS
			preparedStatement.setString(1, customer.getCustomer_name());
			
			//EXECUTE STATEMENT
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("Customer ID is " + resultSet.getInt(1));
				System.out.println("Customer name is " + resultSet.getString(2));
				System.out.println("Customer email is " + resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//CLOSE CONNECTION
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customer;
	}
	
	// TO UPDATE PRODUCT DETAILS
	public boolean updateCustomerDetails(int id,String email) {
		connection = helperClass.getConnection();
		String sql="UPDATE customer SET customer_email=? WHERE customer_id =? ";
		int i=0;
		try {
			//CREATE STATEMENT
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//PASSED THE VALUES TO DELIMITERS/PLACEHOLDERS
			preparedStatement.setString(1,email);
			preparedStatement.setInt(2, id);
			
			//EXECUTE
			i = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//CLOSE CONNECTION
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(i>0) {
			System.out.println("Customer email got updated successfully");
			return true;
		}else {
			System.out.println("Updation failed");
			return false;
		}
	}
	
	 //TO DELETE CUSTOMER DETAILS
	public boolean deletCustomertById(int id) {
		connection = helperClass.getConnection();
		String sql="DELETE FROM customer WHERE customer_id = ?";
		int i=0;
		try {
			//CREATE STATEMENT
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//PASSED THE VALUES TO DELIMITERS/PLACEHOLDERS
			preparedStatement.setInt(1,id);
			
			//EXECUTE
			i =	preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(i>0) {
			System.out.println("Customer details got deleted successfully");
			return true;
		}else {
			System.out.println("failed to delete");
			return false;
		}
	}
	
}