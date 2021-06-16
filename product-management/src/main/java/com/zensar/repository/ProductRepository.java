package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zensar.entites.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	@Query("FROM Product p where p.productName=?1")
	List<Product> test(String name);
	
}

//One interface never ever implements another interface
// but if required one interface can extend from another interface
// CrudRepository,JpaRepository,PagaingAndSortingRepository
