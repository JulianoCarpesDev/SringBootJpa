package com.julianocarpes.startSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.julianocarpes.startSpringBoot.entities.User;
import com.julianocarpes.startSpringBoot.repositories.UserRepository;
import com.julianocarpes.startSpringBoot.services.exceptions.DatabaseExecption;
import com.julianocarpes.startSpringBoot.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User>findAll(){
		
		return repository.findAll();
	}
	public User findById(Long id) {
		
		Optional<User>obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);
	}
	
	public void delete(Long id) {
	    try {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseExecption(e.getMessage());		
	    }	
	} 

	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity,obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
		
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
