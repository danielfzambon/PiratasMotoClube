package com.piratas.piratas.dto;

import java.time.LocalDate;

public class BalancoDTO {
	
	private LocalDate inicio;
	private LocalDate fim;
	private Float valor;
	
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFim() {
		return fim;
	}
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	
	
}
