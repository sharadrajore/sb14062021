package com.zensar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entites.Product;
import com.zensar.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	

	@Autowired
	private ProductRepository repository;
	
	
	public Iterable<Product> getAllProducts() {
		return repository.findAll();
	}

	
	public Product getProduct(int productId) {
		return repository.findById(productId).get();
	}

	
	public Product insertProduct( Product product) {
		return repository.save(product);
	}

	
	public void deleteProduct( int productId) {
		repository.deleteById(productId);

	}

	
	public Product updateProduct( int productId,  Product product) {
		return repository.save(product);
	}



}
