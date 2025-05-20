package com.gestaoagricola.controleagricola.fazenda;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryFazenda extends JpaRepository<Fazenda, Long> {

	List<Fazenda> findAll();

	Fazenda getReferenceById(Fazenda fazendaId);
	
	Optional<Fazenda> findByCodigoFazenda(String codigoFazenda);
}
