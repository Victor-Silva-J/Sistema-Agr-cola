package com.gestaoagricola.controleagricola.estoque;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEstoque extends JpaRepository<Produto, Long>{
	List<Produto> findAll();
}
