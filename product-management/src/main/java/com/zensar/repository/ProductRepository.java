package com.zensar.repository;

import java.util.List;

import com.zensar.entites.Product;

public interface ProductRepository {

	public List<Product> getAllProducts();

	public Product getProduct(int productId);

	public boolean insertProduct(Product product);

	public boolean deleteProduct(int productId);

	public Product updateProduct(int productId, Product product);
}
