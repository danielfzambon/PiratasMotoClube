package com.piratas.piratas.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piratas.piratas.dto.BalancoDTO;
import com.piratas.piratas.dto.DatasDTO;
import com.piratas.piratas.dto.VendaDTO;
import com.piratas.piratas.entities.Comanda;
import com.piratas.piratas.repositories.ComandaRepository;
import com.piratas.piratas.repositories.ContaRepository;
import com.piratas.piratas.services.ComandaService;

@RestController
@RequestMapping(value = "/comanda")
public class ComandaConntroller {
	
	@Autowired
	private ComandaRepository comandaRepository;
    @Autowired
    private ContaRepository contaRepository;
	@Autowired
	private ComandaService service;

	
	@GetMapping("/all")
	public ResponseEntity<List<Comanda>> getAllProducts(){
		List<Comanda> comandaList = comandaRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(comandaList);
	}
	
    @PutMapping("/update")
    public void updateComanda(@RequestBody Comanda data){
    	comandaRepository.save(data);        
    }
    
	@PutMapping(value = "/delete/{id}")
	public void  deleteById(@PathVariable Long id) {	
		comandaRepository.deleteById(id);	
	}
		
    @PutMapping("/insert")
    public void insertComanda(@RequestBody Comanda data){  	  	
    	service.inserirComandaService(data);
   	
    }
    
    @PutMapping("/venda")
    public void venda(@RequestBody VendaDTO vendaDTO){	
    	service.inserirVendaService(vendaDTO);

    }
    
    @GetMapping("/caixaMes")
    private BalancoDTO totalVendas() {
    	BalancoDTO balancoDTO = new BalancoDTO();	
    	balancoDTO.setInicio(LocalDate.now());
    	balancoDTO.setFim(LocalDate.now().minusDays(30));
    	    	
    	Float entrada = comandaRepository.getLucroMes(LocalDate.now(), LocalDate.now().minusDays(30));	

    	balancoDTO.setValor(entrada);
 	
    	return balancoDTO;
    }
 
//    @GetMapping("/liquidoMes")
//    private BalancoDTO totalLiquido() {
//    	BalancoDTO balancoDTO = new BalancoDTO();	
//    	balancoDTO.setInicio(LocalDate.now());
//    	balancoDTO.setFim(LocalDate.now().minusDays(30));
//    	    	
//    	Float entrada = comandaRepository.getLucroMes(LocalDate.now(), LocalDate.now().minusDays(30));
//    	Float saida = contaRepository.getContaMes(LocalDate.now(), LocalDate.now().minusDays(30));   	
//
//    	balancoDTO.setValor(entrada - saida);
// 	
//    	return balancoDTO;
//    			
//    }
    
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

	

}
