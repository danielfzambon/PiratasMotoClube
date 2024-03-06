package com.piratas.piratas.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "comanda")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cliente;
	private ArrayList<Long> produtos = new ArrayList<Long>();
	private Float valor;
	private boolean pago;
	
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
	public ArrayList<Long> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Long> produtos) {
		this.produtos = produtos;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
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
