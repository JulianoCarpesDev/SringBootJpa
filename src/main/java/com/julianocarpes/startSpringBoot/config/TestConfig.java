package com.julianocarpes.startSpringBoot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.julianocarpes.startSpringBoot.entities.User;
import com.julianocarpes.startSpringBoot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Billy", "billy@gmail.com", "984665252", "123456");
		User u2 = new User(null, "Pri", "Pri@gmail.com", "984655417", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
