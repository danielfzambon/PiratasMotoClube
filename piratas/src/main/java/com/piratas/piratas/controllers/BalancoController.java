package com.piratas.piratas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piratas.piratas.repositories.ComandaProdutoRepository;
import com.piratas.piratas.repositories.ComandaRepository;
import com.piratas.piratas.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/comanda")
public class BalancoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ComandaRepository comandaRepository;
	@Autowired
	private ComandaProdutoRepository comandaProdutoRepository;
	
	
//    @GetMapping("/liquido")
//    private BalancoDTO buscaValorLiquido(@RequestBody DatasDTO data) {
//    	BalancoDTO balancoDTO = new BalancoDTO();
//    	balancoDTO.setInicio(data.getInicio());
//    	balancoDTO.setFim(data.getFim());   
//    	
//    	Float entrada = comandaRepository.getLucroMes(data.getInicio(), data.getFim());
//    	
//    	
////    	balancoDTO.setValor(entrada - saida);
//
//    	return balancoDTO;
//    	
//    	
////    	SELECT  SUM( VALOR_VENDA - VALOR_COMPRA ) FROM PRODUTO 
////    	join COMANDA on COMANDA.ID = COMANDAPRODUTO.ID_COMANDA 
////    	join COMANDAPRODUTO on COMANDAPRODUTO.IDPRODUTO  = PRODUTO.ID;
//    			
//    }

}
