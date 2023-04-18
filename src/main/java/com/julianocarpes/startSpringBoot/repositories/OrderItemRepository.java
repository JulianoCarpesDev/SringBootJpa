package com.julianocarpes.startSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocarpes.startSpringBoot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
