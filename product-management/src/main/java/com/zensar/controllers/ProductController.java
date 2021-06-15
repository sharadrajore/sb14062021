package com.zensar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entites.Product;
import com.zensar.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	// http://localhost:8080/products -> GET

	// @RequestMapping(value = "/products", method=RequestMethod.GET)
	@GetMapping("/products")
	public Iterable<Product> getAllProducts() {
		return service.getAllProducts();
	}

	// http://localhost:8080/products/2 -> GET
	// @RequestMapping(value="/products/{productId}",method=RequestMethod.GET)
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {
		return service.getProduct(productId);
	}

	// http://localhost:8080/products -> POST
	// @RequestMapping(value="/products",method=RequestMethod.POST)
	@PostMapping("/products")
	public Product insertProduct(@RequestBody Product product) {
		return service.insertProduct(product);
	}

	// http://localhost:8080/products/2 -> Delete
	// @RequestMapping(value="/products/{productId}",method=RequestMethod.DELETE)
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		service.deleteProduct(productId);
	}

	// http://localhost:8080/products/{productId} -> PUT

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		return service.updateProduct(productId, product);
	}
}
