package com.piratas.piratas.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piratas.piratas.entities.Comanda;
//@NoRepositoryBean
public interface ComandaRepository  extends JpaRepository<Comanda, Long>{
	
	List<Comanda> findByPagoTrue();
	
	List<Comanda> findByPagoFalse();
	
	List<Comanda> findByDataBetween(LocalDate data, LocalDate datafim);

			
	@Query("SELECT c FROM Comanda c WHERE c.cliente = ?1 ")
	List<Comanda> getClienteByNome(String cliente);
	
	@Query(" select SUM(valor) FROM Comanda WHERE data <= ?1 AND data >= ?2 ")
	public Float getLucroMes(LocalDate inicio, LocalDate fim);


}
