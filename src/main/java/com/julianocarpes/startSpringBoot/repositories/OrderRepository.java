package com.julianocarpes.startSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocarpes.startSpringBoot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
