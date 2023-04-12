package com.julianocarpes.startSpringBoot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianocarpes.startSpringBoot.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findALL(){
		User u = new User(1L, "Juliano", "juliano@gmail.com", "992545253", "12345");
		return ResponseEntity.ok().body(u);
	}
}
