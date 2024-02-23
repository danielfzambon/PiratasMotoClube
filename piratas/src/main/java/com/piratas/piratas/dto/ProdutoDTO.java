package com.piratas.piratas.dto;

import com.piratas.piratas.entities.Produto;

public class ProdutoDTO {
	
	private Long id;
	private String produto;
	private Float valor;
	
	public ProdutoDTO() {
	}
	

	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.produto = produto.getProduto();
		this.valor = produto.getValor();
	}
	
	public ProdutoDTO(Long id, String produto, Float valor) {
		super();
		this.id = id;
		this.produto = produto;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
