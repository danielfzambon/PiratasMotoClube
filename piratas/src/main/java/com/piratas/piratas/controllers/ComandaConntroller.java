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

@RestController
@RequestMapping(value = "/comanda")
public class ComandaConntroller {
	
	@Autowired
	private ComandaRepository comandaRepository;
	@Autowired
	private ProdutoRepository productRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Comanda>> getAllProducts(){
		List<Comanda> comandaList = comandaRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(comandaList);
	}
	
    @PutMapping("/insert")
    public void insertComanda(@RequestBody Comanda data){
    	float valor = 0;
    	
    	if(!data.getProdutos().isEmpty() ) { 		
        	for(Long idProduto : data.getProdutos()) {		
        		Optional<Produto>  product = productRepository.findById(idProduto);
        		valor = valor + product.get().getValor();
        		
        	}     	
        	data.setValor(valor);  		
    	}      	
    	comandaRepository.save(data);        
    }
    
    @PutMapping("/update")
    public void updateComanda(@RequestBody Comanda data){
    	float valor = 0;
    	
    	if(!data.getProdutos().isEmpty() ) { 		
        	for(Long idProduto : data.getProdutos()) {		
        		Optional<Produto>  product = productRepository.findById(idProduto);
        		valor = valor + product.get().getValor();
        		
        	}     	
        	data.setValor(valor);  		
    	}      	
    	comandaRepository.save(data);        
    }
    
	@PutMapping(value = "/add/{idComanda}/{idProduto}")
	public void venda(@PathVariable Long idComanda ,@PathVariable Long idProduto) {
		
		Optional<Comanda> comandaOld = comandaRepository.findById(idComanda);	
		
		List<Long> itens = comandaOld.get().getProdutos();
		
		itens.add(idProduto);
		
		comandaOld.get().setProdutos(itens);
				
		comandaRepository.save(comandaOld.get());  

	}
	
	@PutMapping(value = "/remove/{idComanda}/{idProduto}")
	public void remodeItem(@PathVariable Long idComanda ,@PathVariable int idProduto) {
		
		Optional<Comanda> comandaOld = comandaRepository.findById(idComanda);	
		float valor = 0;
		List<Long> itens = comandaOld.get().getProdutos();
		
		
		comandaOld.get().getProdutos().remove(idProduto);
		
		System.out.println("remore: " + comandaOld.get().toString());
		
    	for(Long id : comandaOld.get().getProdutos()) {		
    		Optional<Produto>  product = productRepository.findById(id);
    		valor = valor + product.get().getValor();
    		
    	}     	
    	comandaOld.get().setValor(valor);  
				
		comandaRepository.save(comandaOld.get());  

	}

}
