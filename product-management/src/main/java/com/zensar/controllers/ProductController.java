package com.zensar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entites.Product;

@RestController
public class ProductController {

	// CRUD R C U  D

	private List<Product> products = new ArrayList<>();

	public ProductController() {
		products.add(new Product(1, "Laptop", 50000));
		products.add(new Product(2, "HDD", 4500));
		products.add(new Product(3, "Mobile", 9999));
	}

	// http://localhost:8080/products -> GET

	// @RequestMapping(value = "/products", method=RequestMethod.GET)
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return products;
	}

	// http://localhost:8080/products/2 -> GET
	// @RequestMapping(value="/products/{productId}",method=RequestMethod.GET)
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;

	}

	// http://localhost:8080/products -> POST
	// @RequestMapping(value="/products",method=RequestMethod.POST)
	@PostMapping("/products")
	public boolean insertProduct(@RequestBody Product product) {
		return products.add(product);
	}

	// http://localhost:8080/products/2 -> Delete
	// @RequestMapping(value="/products/{productId}",method=RequestMethod.DELETE)
	@DeleteMapping("/products/{productId}")
	public boolean deleteProduct(@PathVariable("productId") int productId) {

		for (Product product : products) {
			if (product.getProductId() == productId) {
				return products.remove(product);
			}
		}
		return false;

	}

	// http://localhost:8080/products/{productId} -> PUT
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		Product product2 = getProduct(productId);

		product2.setProductId(product.getProductId());
		product2.setProductName(product.getProductName());
		product2.setProductCost(product.getProductCost());

		return product2;
	}
}
