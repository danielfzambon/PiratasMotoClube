package com.piratas.piratas.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piratas.piratas.entities.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
	
	@Query("SELECT   valorVenda - valorCompra  FROM Produto   ")
	public Float getLucroMes(LocalDate inicio, LocalDate fim);

}
