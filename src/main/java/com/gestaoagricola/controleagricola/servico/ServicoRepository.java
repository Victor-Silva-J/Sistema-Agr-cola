package com.gestaoagricola.controleagricola.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

	List<Servico> findAll();
	Optional<Servico> findByCodigoServico(String codigoServico);
}
