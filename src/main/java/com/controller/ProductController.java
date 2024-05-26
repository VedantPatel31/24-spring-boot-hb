package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepo; 
	
	ProductEntity productEntity;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductEntity productEntity){
		
		//database save ! 
		productRepo.save(productEntity);
		
		return ResponseEntity.ok(productEntity);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllProducts(){
		
		List<ProductEntity> products  = productRepo.findAll(); 
		return ResponseEntity.ok(products);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable int id){
		productRepo.deleteById(id);
		return ResponseEntity.ok("product deleted successfully");
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProductById(@PathVariable Integer id, @RequestBody ProductEntity productEntity){
		productEntity.setProductId(id);
		productRepo.save(productEntity);
		return ResponseEntity.ok("product update successfully");
	}
	
	//    /product/create   /product/all 
	
}