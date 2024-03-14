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

import com.piratas.piratas.dto.DatasDTO;
import com.piratas.piratas.entities.Comanda;
import com.piratas.piratas.entities.ComandaProduto;
import com.piratas.piratas.repositories.ComandaProdutoRepository;
import com.piratas.piratas.repositories.ComandaRepository;
import com.piratas.piratas.services.ComandaService;

@RestController
@RequestMapping(value = "/comanda")
public class ComandaConntroller {
	
	@Autowired
	private ComandaRepository comandaRepository;
	@Autowired
	private ComandaProdutoRepository comandaProdutoRepository;
	@Autowired
	private ComandaService service;

	
	@GetMapping("/all")
	public ResponseEntity<List<Comanda>> getAllProducts(){
		List<Comanda> comandaList = comandaRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(comandaList);
	}
	
	@PostMapping("/fechamento")
	public ResponseEntity<Float> getBalanco(@RequestBody Comanda data ){
		Float valor = comandaRepository.getListComanda(data.getId());
	
		return ResponseEntity.status(HttpStatus.OK).body(valor);
	}
	
	@PostMapping("/mes")
	public ResponseEntity<Float> getBalancoMes(@RequestBody DatasDTO datas){
		Float valor = comandaRepository.getLucroMes(datas.getInicio(),datas.getFim());
	
		return ResponseEntity.status(HttpStatus.OK).body(valor);
	}
	
    @PutMapping("/insert")
    public void insertComanda(@RequestBody Comanda data){  	
    	comandaRepository.save(data); 
    	
    	ComandaProduto comandaProduto = new ComandaProduto();
    	
    	comandaProduto.setCliente(data.getCliente());
    	
    	comandaProdutoRepository.save(comandaProduto);
    	
    }
    
    @PutMapping("/update")
    public void updateComanda(@RequestBody Comanda data){
    	comandaRepository.save(data);        
    }
    
    @PutMapping("/venda")
    public void venda(@RequestBody ComandaProduto comandaProduto){

//    	Optional<Comanda> comanda = comandaRepository.findById(comandaProduto.getId());
    	List<Long> ids = null;
    	ids.add(comandaProduto.getId());
    	
    	List<Comanda> comanda = comandaRepository.findAllById(ids);
    }
    	
	@PutMapping(value = "/add/{idComanda}/{idProduto}")
	public void venda(@PathVariable Long idComanda ,@PathVariable Long idProduto) {	
		Optional<Comanda> comandaOld = comandaRepository.findById(idComanda);				
		comandaRepository.save(comandaOld.get());  

	}
	

}
