package com.piratas.piratas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.piratas.piratas.controllers.ProdutoConntroller;
import com.piratas.piratas.entities.Comanda;
import com.piratas.piratas.entities.Produto;

@Service
public class ComandaService {
	
	@Autowired
	private ProdutoConntroller produtoConntroller;
	
	public Comanda venda(@RequestBody Comanda data) {		
		ArrayList<Long> produtos = data.getProdutos();
		Float total = 0f;
		if(!produtos.isEmpty()){	
			for(Long prod : produtos) {								
				Optional<Produto> valor = produtoConntroller.findById(prod);
				total = total + valor.get().getValor();		
			}
						
		}
		data.setValor(total);		
		return data;
			
	}
	
	public Comanda vendaPromocao(@RequestBody Comanda data) {		
		ArrayList<Long> produtos = data.getProdutos();
		Float total = 0f;
		int promo = 0;
		if(!produtos.isEmpty()){	
			for(Long prod : produtos) {		
				
				Optional<Produto> valor = produtoConntroller.findById(prod);
								
					if(valor.get().getPromocao() == true && promo > 5) {
												
							total = total + valor.get().getValor();
		
						
					
					}
					if(promo == 5) {
						promo = 0;
					}
					
					promo++;
				
				
				
			}
						
		}
		data.setValor(total);		
		return data;
			
	}
	

}
