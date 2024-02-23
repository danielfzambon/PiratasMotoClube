package com.piratas.piratas.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piratas.piratas.dto.ProdutoDTO;
import com.piratas.piratas.entities.Produto;
import com.piratas.piratas.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
		Produto entity = repository.findById(id).get();
		ProdutoDTO dto = new ProdutoDTO(entity);
		return dto;
	}
	
	
	@Transactional(readOnly = true)
	public void deleteById(Long id) {
		repository.deleteById(id);

	}



}
