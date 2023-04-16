package com.julianocarpes.startSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocarpes.startSpringBoot.entities.Category;
import com.julianocarpes.startSpringBoot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
