package com.piratas.piratas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piratas.piratas.entities.ComandaProduto;

public interface ComandaProdutoRepository extends JpaRepository<ComandaProduto, Long>{
	
	@Query(" FROM ComandaProduto cp WHERE cp.idComanda = ?1 ")
	ComandaProduto getComandaProdutoByComanda(Long idComanda);

}
