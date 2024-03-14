package com.piratas.piratas.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piratas.piratas.entities.Comanda;
//@NoRepositoryBean
public interface ComandaRepository  extends JpaRepository<Comanda, Long>{
	
	List<Comanda> findByPagoTrue();
	
	List<Comanda> findByPagoFalse();
	
	@Query(value = " select SUM(valor) from Comanda c where data BETWEEN :startDate AND :endDate")
	public Float getLucroMes(@Param("startDate")Date inicio,@Param("endDate")Date fim);
	
	
	@Query(value = " select SUM(valor) from Comanda c where 1=1 ")
	public Float getListComanda(@Param("val")Long id);

}
