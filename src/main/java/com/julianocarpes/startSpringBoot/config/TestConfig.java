package com.julianocarpes.startSpringBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.julianocarpes.startSpringBoot.entities.Category;
import com.julianocarpes.startSpringBoot.entities.Order;
import com.julianocarpes.startSpringBoot.entities.OrderItem;
import com.julianocarpes.startSpringBoot.entities.Product;
import com.julianocarpes.startSpringBoot.entities.User;
import com.julianocarpes.startSpringBoot.entities.enuns.OrderStatus;
import com.julianocarpes.startSpringBoot.repositories.CategoryRepository;
import com.julianocarpes.startSpringBoot.repositories.OrderItemRepository;
import com.julianocarpes.startSpringBoot.repositories.OrderRepository;
import com.julianocarpes.startSpringBoot.repositories.ProductRepository;
import com.julianocarpes.startSpringBoot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		User u1 = new User(null, "Lucas", "lucas@gmail.com", "984665562", "123456");
		User u2 = new User(null, "Vanessa", "vanessa@gmail.com", "984655417", "123456");
		User u3 = new User(null, "Rafael", "rafa@gmail.com", "999815023", "123456");

		Order o1 = new Order(null, Instant.parse("2023-04-20T19:53:07Z"), OrderStatus.PAYD, u1);
		Order o2 = new Order(null, Instant.parse("2023-04-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2023-04-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		userRepository.saveAll(Arrays.asList(u3, u1, u2));

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
	}

}
