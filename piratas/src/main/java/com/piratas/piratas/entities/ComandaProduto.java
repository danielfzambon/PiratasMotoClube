package com.piratas.piratas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "comandaproduto")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ComandaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cliente;
	private Long idComanda;
	private Long Idproduto;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Long getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(Long idComanda) {
		this.idComanda = idComanda;
	}
	public Long getIdproduto() {
		return Idproduto;
	}
	public void setIdproduto(Long idproduto) {
		Idproduto = idproduto;
	}
	
	@Override
	public String toString() {
		return "ComandaProduto [cliente=" + cliente + ", idComanda=" + idComanda + ", Idproduto=" + Idproduto + "]";
	}
	
}
