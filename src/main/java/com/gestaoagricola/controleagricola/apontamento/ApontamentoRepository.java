package com.gestaoagricola.controleagricola.apontamento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApontamentoRepository extends JpaRepository<Apontamento, Long>{

	List<Apontamento> findAll();
}
