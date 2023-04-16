package com.julianocarpes.startSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocarpes.startSpringBoot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
