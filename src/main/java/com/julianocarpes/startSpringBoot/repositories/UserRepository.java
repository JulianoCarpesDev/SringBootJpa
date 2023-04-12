package com.julianocarpes.startSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianocarpes.startSpringBoot.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
