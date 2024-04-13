package com.piratas.piratas.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piratas.piratas.dto.BalancoDTO;
import com.piratas.piratas.dto.DatasDTO;
import com.piratas.piratas.entities.Conta;
import com.piratas.piratas.repositories.ComandaRepository;
import com.piratas.piratas.repositories.ContaRepository;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {
	
	@Autowired
	private ComandaRepository comandaRepository;
    @Autowired
    private ContaRepository contaRepository;


	@GetMapping("/all")
	public ResponseEntity<List<Conta>> getAllProducts(){
		List<Conta> comandaList = contaRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(comandaList);
	}
	
    @PutMapping("/update")
    public void updateComanda(@RequestBody Conta data){
    	contaRepository.save(data);        
    }
		
    @PutMapping("/insert")
    public void insertComanda(@RequestBody Conta data){  	  	
    	contaRepository.save(data);
   	
    }
    
    @GetMapping("/contaMes")
    private BalancoDTO totalVendas() {
    	BalancoDTO balancoDTO = new BalancoDTO();
    	balancoDTO.setInicio(LocalDate.now());
    	balancoDTO.setFim(LocalDate.now().minusDays(30));
    	
    	balancoDTO.setValor(contaRepository.getContaMes(LocalDate.now(), LocalDate.now().minusDays(30)));

    	return balancoDTO;
    			
    }
    
    @GetMapping("/conta")
    private BalancoDTO buscaValorVendas(@RequestBody DatasDTO data) {
    	BalancoDTO balancoDTO = new BalancoDTO();
    	balancoDTO.setInicio(data.getInicio());
    	balancoDTO.setFim(data.getFim());
    	
    	balancoDTO.setValor(contaRepository.getContaMes(data.getInicio(), data.getFim()));

    	return balancoDTO;
    			
    }
    
    @GetMapping("/liquido")
    private BalancoDTO buscaValorLiquido(@RequestBody DatasDTO data) {
    	BalancoDTO balancoDTO = new BalancoDTO();
    	balancoDTO.setInicio(data.getInicio());
    	balancoDTO.setFim(data.getFim());   
    	
    	Float entrada = comandaRepository.getLucroMes(data.getInicio(), data.getFim());
    	Float saida = contaRepository.getContaMes(data.getInicio(), data.getFim());

    	balancoDTO.setValor(entrada - saida);

    	return balancoDTO;
    			
    }
    
    @GetMapping("/liquidoMes")
    private BalancoDTO totalLiquido() {
    	BalancoDTO balancoDTO = new BalancoDTO();	
    	balancoDTO.setInicio(LocalDate.now());
    	balancoDTO.setFim(LocalDate.now().minusDays(30));
    	    	
    	Float entrada = comandaRepository.getLucroMes(LocalDate.now(), LocalDate.now().minusDays(30));
    	Float saida = contaRepository.getContaMes(LocalDate.now(), LocalDate.now().minusDays(30));   	

    	balancoDTO.setValor(entrada - saida);
 	
    	return balancoDTO;
    			
    }

	

}
