package com.piratas.piratas.dto;

import java.time.LocalDate;

public class DatasDTO {
	
	private LocalDate inicio;
	private LocalDate fim;
	
	public DatasDTO() {
		super();
	}

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

	
	

}
