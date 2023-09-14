package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

@RestController
@RequestMapping(path="/api/v1/products")
public class ProductController {

	@Autowired
	private ProductRepository reposity;
	
	@GetMapping("")
	public List<Product> getAllProduct(){
		return reposity.findAll();
	}
	@GetMapping("/{id}")
	public Product findId(@PathVariable Long id){
		return reposity.findById(id).orElseThrow(()->new RuntimeException("cannot find product with id "+id));
	}
}
