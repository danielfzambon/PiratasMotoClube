package com.piratas.piratas.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piratas.piratas.entities.Produto;
import com.piratas.piratas.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoConntroller {
		
	@Autowired
	private ProdutoRepository productRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Produto>> getAllProducts(){
		List<Produto> productsList = productRepository.findAll();
		productsList.toString();
		return ResponseEntity.status(HttpStatus.OK).body(productsList);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Produto> findById(@PathVariable Long id) {	
		Optional<Produto> product = productRepository.findById(id);	
		return product;
	}
	
    @PutMapping("/insert")
    public void insertProduto(@RequestBody Produto data){   	
    	productRepository.save(data);
        
    }
	
    @PostMapping("/update")
    public void registerProduct(@RequestBody Produto data){   	
    	productRepository.save(data);
        
    }
	
	@PutMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		productRepository.deleteById(id);
	}

}
