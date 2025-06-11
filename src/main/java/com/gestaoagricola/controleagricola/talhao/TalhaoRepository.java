package com.gestaoagricola.controleagricola.talhao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoagricola.controleagricola.fazenda.Fazenda;

public interface TalhaoRepository extends JpaRepository<Talhao, Long> {
	
	List<Talhao> findByFazenda(Fazenda fazendaId);
	
	List<Talhao> findAll();
	
	Optional<Talhao> findByCodigo(String Codigo);
	
	int countByFazenda(Fazenda fazenda);
}
