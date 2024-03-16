package com.piratas.piratas.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piratas.piratas.entities.Conta;

public interface ContaRepository  extends JpaRepository<Conta, Long>{
	
	@Query(" select SUM(valor) FROM Conta WHERE data <= ?1 AND data >= ?2 ")
	public Float getContaMes(LocalDate inicio, LocalDate fim);

	

}
