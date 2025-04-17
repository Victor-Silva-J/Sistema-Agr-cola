package com.gestaoagricola.controleagricola.funcionario;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarFuncionario(
		@NotNull
		Long id,
		Boolean ativo,
		Integer secao,
		Funcao funcao,
		Tipo tipo,
		Integer turma,
		String nome,
		LocalDate dataNascimento,
		String cpf,
		String ctps,
		Date demissao,
		Date admissao,
		String pis
		) {
}
