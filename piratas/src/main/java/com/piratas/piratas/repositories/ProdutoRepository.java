package com.piratas.piratas.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.piratas.piratas.entities.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

}
