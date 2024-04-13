package com.piratas.piratas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String produto;
	private Float valorCompra;
	private Float valorVenda;
	private Boolean promocao;
	
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
	public Float getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Float valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Float getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Float valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Boolean getPromocao() {
		return promocao;
	}
	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}

}
