package com.piratas.piratas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piratas.piratas.entities.ComandaProduto;

public interface ComandaProdutoRepository extends JpaRepository<ComandaProduto, Long>{

	ComandaProduto findByCliente(String cliente);
	
	
//	@Query( "select * from comandaproduto  where idComanda = id " )
	ComandaProduto findByIdComanda(Long id);
	

	List<ComandaProduto> findByIdIn(List<Long> ids);
	

	
}
