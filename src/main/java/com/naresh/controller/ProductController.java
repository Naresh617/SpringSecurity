package com.naresh.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.modal.Product;
import com.naresh.repo.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository prodRepository;
	
	@PostMapping("/saveproduct")
    public ResponseEntity<Product> create(@RequestBody @Valid Product product) {
        Product savedProduct = prodRepository.save(product);
        URI productURI = URI.create("/products/" + savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }
     
    @GetMapping("/getallproducts")
    public List<Product> list() {
        return prodRepository.findAll();
    }

}
