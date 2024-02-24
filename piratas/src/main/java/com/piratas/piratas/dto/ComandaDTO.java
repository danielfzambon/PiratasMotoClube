package com.piratas.piratas.dto;

import java.util.List;

public class ComandaDTO {
	
	private Long id;
	private String cliente;
	private List<String> produtos;
	private float valor;
	private boolean pago;
	
	public ComandaDTO() {
		
	}
	
	public ComandaDTO(Long id, String cliente, List<String> produtos, float valor, boolean pago) {
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

	public List<String> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<String> produtos) {
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
