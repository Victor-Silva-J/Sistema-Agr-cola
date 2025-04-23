package com.gestaoagricola.controleagricola.funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface funcionarioRepository extends JpaRepository<Funcionario, Long> {
	
	List<Funcionario> findAll();

	List<Funcionario> findAllByTurmaAndAtivo(int turma, Boolean ativo);



}
