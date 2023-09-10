package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.product.configuration.HelperClass;
import com.product.dto.Product;

public class ProductDao{
	
	HelperClass helperClass=new HelperClass();
	Connection connection=null;
	
	//TO INSERT Product DETAILS
	public Product saveProduct(Product product) {
		
		connection = helperClass.getConnection();
		String sql="INSERT INTO product VALUES(?,?,?)";
		
		try {
		//CREATE STATEMENT
	    PreparedStatement preparedStatement=connection.prepareStatement(sql);
	    
		//PASSED THE VALUES TO DELIMITERS/PLACEHOLDERS
		preparedStatement.setInt(1,product.getProduct_id());
		preparedStatement.setString(2,product.getProduct_name());
		preparedStatement.setDouble(3,product.getProduct_price());
		
		//EXECUTE
		preparedStatement.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
			try {
				//CLOSE CONNECTION
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return product;
	}
	
	//TO SHOW ALL PRODUCT DETAILS
	public Product availableProduct(Product product) {
		connection = helperClass.getConnection();
		String sql= "SELECT * from product";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery(sql);
		while(resultSet.next()){
				System.out.println("Product ID is " +resultSet.getInt(1));
				System.out.println("Product name is " +resultSet.getString(2));
				System.out.println("Product price is " +resultSet.getDouble(3));
				System.out.println("================");
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
		return product;
	}
		
	//TO SHOW PRODUCT BASED ON NAME
	public Product getProduct(Product product) {
		connection = helperClass.getConnection();
		String sql= "SELECT * FROM product WHERE product_name = ?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//PASSED THE VALUES TO DELIMITERS/PLACEHOLDERS
			preparedStatement.setString(1, product.getProduct_name());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println("Product ID is " + resultSet.getInt(1));
				System.out.println("Product name is " + resultSet.getString(2));
				System.out.println("Product price is " + resultSet.getDouble(3));
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
		
		return product;
	}
	// TO UPDATE PRODUCT DETAILS
	public boolean updateProductDetails(int id,double price) {
		connection = helperClass.getConnection();
		String sql="UPDATE product SET product_price=? WHERE product_id =? ";
		int i=0;
		try {
			//CREATE STATEMENT
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			//PASSED THE VALUES TO DELIMITERS/PLACEHOLDERS
			preparedStatement.setDouble(1,price);
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
			System.out.println("Product got updated successfully");
			return true;
		}else {
			System.out.println("Updation failed");
			return false;
		}
	}
	
	 //TO DELETE A PRODUCT
	public boolean deletProductById(int id) {
		connection = helperClass.getConnection();
		String sql="DELETE FROM product WHERE product_id = ?";
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
			System.out.println("Product got deleted successfully");
			return true;
		}else {
			System.out.println("failed to delete");
			return false;
		}
	}
}
	
	