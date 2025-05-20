package com.gestaoagricola.controleagricola.talhao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoagricola.controleagricola.fazenda.Fazenda;

public interface TalhaoRepository extends JpaRepository<Talhao, Long> {
	
	List<Talhao> findByFazendaId(Long fazendaId);
	int countByFazenda(Fazenda fazenda);
}
