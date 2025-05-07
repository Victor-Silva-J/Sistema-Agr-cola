package com.gestaoagricola.controleagricola.fazenda;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryFazenda extends JpaRepository<Fazenda, Long> {

	List<Fazenda> findAll();
}
