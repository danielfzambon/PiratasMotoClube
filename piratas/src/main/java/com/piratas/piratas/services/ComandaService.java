package com.piratas.piratas.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piratas.piratas.dto.VendaDTO;
import com.piratas.piratas.entities.Comanda;
import com.piratas.piratas.entities.ComandaProduto;
import com.piratas.piratas.entities.Produto;
import com.piratas.piratas.repositories.ComandaProdutoRepository;
import com.piratas.piratas.repositories.ComandaRepository;
import com.piratas.piratas.repositories.ProdutoRepository;

@Service
public class ComandaService {
	
	@Autowired
	private ComandaRepository comandaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ComandaProdutoRepository comandaProdutoRepository;
	
	public void inserirComandaService(Comanda data) {
		ComandaProduto comandaProduto = new ComandaProduto(); 
//		Date d = new Date();
		
		data.setData(LocalDate.now());
		data.setPago(false);
//		comandaRepository.save(data);
//
//		List<Comanda> comanda = comandaRepository.getClienteByNome(data.getCliente());
//		
//		if(comanda.size() == 1) {
//			
//			comandaProduto.setIdComanda(comanda.get(0).getId()); 
//			comandaProdutoRepository.save(comandaProduto);
//			
//		}else {
//				Criar validacao de inserir nomes duplicados
//		}
		
		
		comandaRepository.save(data);
		
	}

	public void inserirVendaService(VendaDTO vendaDTO) {
		ComandaProduto comandaProduto = new ComandaProduto();
//		Comanda comanda = new Comanda();
		comandaProduto.setIdComanda(vendaDTO.getIdcomanda());
		comandaProduto.setIdproduto(vendaDTO.getIdProduto());
		
		Optional<Produto> produto  = produtoRepository.findById(vendaDTO.getIdProduto());
		Optional<Comanda> comanda  = comandaRepository.findById(vendaDTO.getIdcomanda());
		
		Float valor = comanda.get().getValor();
		
		comanda.get().setValor(valor = valor + produto.get().getValor());
		
		comandaProdutoRepository.save(comandaProduto);
		comandaRepository.save(comanda.get());
	}

}
