package com.product.controller;

import java.util.Scanner;

import com.product.dto.Product;
import com.product.service.ProductService;

public class Main {
   
	public static void main(String[] args) {
		int id;
		String name;
		double price;
		
		Product product=new Product();
		
		System.out.println("WELCOME TO PRODUCT MANAGEMENT SYSTEM");
		
		Scanner sc = new Scanner(System.in);
		
			System.out.println("1.Add Product");
			System.out.println("2.Show All Product");
			System.out.println("3.Show Product Based On Name");
			System.out.println("4.Update Product");
			System.out.println("5.Delete Product");
			
			System.out.println("Enter a choice: ");
			int ch=sc.nextInt();
			
			switch(ch) {
			case 1:
				//TO INSERT PRODUCT DETAILS
				ProductService p1=new ProductService();
				
				System.out.println("Enter product ID: ");
				id=sc.nextInt();
				
				System.out.println("Enter product name: ");
				name=sc.next();
				
				System.out.println("Enter product price: ");
				price=sc.nextDouble();
				
				product.setProduct_id(id);
				product.setProduct_name(name);
				product.setProduct_price(price);
				
				Product p = p1.saveProduct(product);
		        System.out.println(p.getProduct_id() +" product saved successfully");
			    break;
			    
			 case 2:  
				 //TO SHOW ALL THE AVAILABLE PRODUCT
				 ProductService p2=new ProductService();
				 p2.availableProduct(product);
				 break;
			
			 case 3:
				 //TO SHOW PRODUCT BASED ON NAME
				 ProductService p3=new ProductService();
				 
				 System.out.println("Enter product name: ");
				 name=sc.next();
				 product.setProduct_name(name);
				 p3.getProduct(product);
			    break;
			    
			 case 4:
				// TO UPDATE PRODUCT DETAILS
				 ProductService p4=new ProductService();
				 
				 System.out.println("Enter product id : ");
				 id=sc.nextInt();
				 product.setProduct_id(id);
				 
				 System.out.println("Enter product price to be updated: ");
				 price=sc.nextDouble();
				 product.setProduct_price(price);
				 
				p4.updateProductDetails(id, price);
				break;
				
			 case 5:
				 //TO DELETE A PRODUCT
				 ProductService p5=new ProductService();
				 
				 System.out.println("Enter product id to be deleted: ");
				 id=sc.nextInt();
				 product.setProduct_id(id);
				 
				 boolean result = p5.deletProductById(id);
				 System.out.println(result);
				 
				 break;
				
			default:
				System.out.println("....Enter vaild Choice....");
			}
			System.out.println("===========================");
	}

}
