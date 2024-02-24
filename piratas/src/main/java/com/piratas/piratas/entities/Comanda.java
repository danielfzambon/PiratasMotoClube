package com.piratas.piratas.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "comanda")
@Entity
public class Comanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cliente;
	private List<Long> produtos;
	private Float valor;
	private boolean pago;
	
	public Comanda() {
		
	}
	
	public Comanda(Long id, String cliente, List<Long> produtos, Float valor, boolean pago) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.produtos = produtos;
		this.valor = valor;
		this.pago = pago;
	}

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

	public List<Long> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Long> produtos) {
		this.produtos = produtos;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return "Comanda [cliente=" + cliente + ", produtos=" + produtos + ", valor=" + valor + ", pago=" + pago + "]";
	}
	
}
