package com.zensar.repository;

import org.springframework.data.repository.CrudRepository;

import com.zensar.entites.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

	
}

//One interface never ever implements another interface
// but if required one interface can extend from another interface
// CrudRepository,JpaRepository,PagaingAndSortingRepository
