package com.piratas.piratas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piratas.piratas.entities.Comanda;
import com.piratas.piratas.entities.Integrante;
import com.piratas.piratas.entities.Produto;
import com.piratas.piratas.repositories.ComandaRepository;
import com.piratas.piratas.repositories.IntegrandeRepository;
import com.piratas.piratas.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/integrante")
public class IntegranteConntroller {
	
	@Autowired
	private IntegrandeRepository repository;

	
	@GetMapping("/all")
	public ResponseEntity<List<Integrante>> getAllProducts(){
		List<Integrante> comandaList = repository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(comandaList);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Integrante>  findById(@PathVariable Long id) {	
		Optional<Integrante> product = repository.findById(id);	
		return product;
	}
	
    @PutMapping("/insert")
    public void insertComanda(@RequestBody Integrante data){
    	repository.save(data);        
    }
    
    @PutMapping("/update")
    public void updateComanda(@RequestBody Integrante data){
    	repository.save(data);        
    }
    
	@GetMapping(value = "/delete/{id}")
	public void  deleteById(@PathVariable Long id) {	
		repository.deleteById(id);	
	}
    

	

}
