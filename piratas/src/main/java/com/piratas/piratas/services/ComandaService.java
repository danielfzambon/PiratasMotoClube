package com.piratas.piratas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piratas.piratas.controllers.ProdutoConntroller;

@Service
public class ComandaService {
	
	@Autowired
	private ProdutoConntroller produtoConntroller;

}
