package com.example.demo.data;
import com.example.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.demo.repo.ProductRepository;

@Configurable
public class Database {
	private static final Logger logger=LoggerFactory.getLogger(Database.class);
	
	@Bean
	CommandLineRunner initDatabase(ProductRepository productRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
			 Product p1=new Product(1L,"Macbook 16",2020,2400,"");
			 Product p2=new Product(2L,"iphone 15",2021,2000,"");
			// System.out.println("insert data "+productRepo.save(p1));
			// System.out.println("insert data "+productRepo.save(p2));
			logger.info("insert data "+productRepo.save(p1));
			logger.info("insert data "+productRepo.save(p2));
			 
			}
		};
	}
}
