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
import com.piratas.piratas.entities.Produto;
import com.piratas.piratas.repositories.ComandaRepository;
import com.piratas.piratas.repositories.ProdutoRepository;
import com.piratas.piratas.services.ComandaService;

@RestController
@RequestMapping(value = "/comanda")
public class ComandaConntroller {
	
	@Autowired
	private ComandaRepository comandaRepository;
	@Autowired
	private ComandaService service;

	
	@GetMapping("/all")
	public ResponseEntity<List<Comanda>> getAllProducts(){
		List<Comanda> comandaList = comandaRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(comandaList);
	}
	
    @PutMapping("/insert")
    public void insertComanda(@RequestBody Comanda data){
    	
    	data = service.venda(data);
    	
    	comandaRepository.save(data);        
    }
    
    @PutMapping("/update")
    public void updateComanda(@RequestBody Comanda data){
    	comandaRepository.save(data);        
    }
    
	@PutMapping(value = "/add/{idComanda}/{idProduto}")
	public void venda(@PathVariable Long idComanda ,@PathVariable Long idProduto) {	
		Optional<Comanda> comandaOld = comandaRepository.findById(idComanda);				
		comandaRepository.save(comandaOld.get());  

	}
	

}
