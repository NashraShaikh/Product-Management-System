package com.product.service;

import com.product.dao.ProductDao;
import com.product.dto.Product;

public class ProductService {
	
	ProductDao productDao=new ProductDao();
	
	// TO INSERT PRODUCT DETAILS
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	//TO SHOW ALL THE AVAILABLE PRODUCT
	public Product availableProduct(Product product) {
		return productDao.availableProduct(product);
	}
	
	//TO SHOW PRODUCT BASED ON NAME
	public Product getProduct(Product product) {
		return productDao.getProduct(product);
	}
	
	// TO UPDATE PRODUCT DETAILS
	public boolean updateProductDetails(int id,double price) {
		return productDao.updateProductDetails(id, price);
	}
	
	//TO DELETE A PRODUCT
	public boolean deletProductById(int id) {
		return productDao.deletProductById(id);
	}
}


