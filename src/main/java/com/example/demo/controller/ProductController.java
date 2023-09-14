package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.*;
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
	public ResponseEntity<ResponseObject> findId(@PathVariable Long id){
		Optional<Product> foundProduct=reposity.findById(id);
		return foundProduct.isPresent()?ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Query product suscess", foundProduct)):
			
			ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("failed", "Cannot find id "+id, ""));
		
	}
	
	@PostMapping("/insert")
	public ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct){
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","insert product suscess", reposity.save(newProduct)));
		
	}
}
