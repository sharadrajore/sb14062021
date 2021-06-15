package com.zensar.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zensar.entites.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private List<Product> products = new ArrayList<>();

	public ProductRepositoryImpl() {
		products.add(new Product(1, "Laptop", 50000));
		products.add(new Product(2, "HDD", 4500));
		products.add(new Product(3, "Mobile", 9999));
	}

	
	public List<Product> getAllProducts() {
		return products;
	}

	
	public Product getProduct(int productId) {

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;

	}

	
	public boolean insertProduct( Product product) {
		return products.add(product);
	}

	
	public boolean deleteProduct( int productId) {

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return products.remove(product);
			}
		}
		return false;

	}

	
	public Product updateProduct( int productId,  Product product) {
		Product product2 = getProduct(productId);

		product2.setProductId(product.getProductId());
		product2.setProductName(product.getProductName());
		product2.setProductCost(product.getProductCost());

		return product2;
	}




}
