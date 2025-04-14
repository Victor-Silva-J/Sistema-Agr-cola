package com.gestaoagricola.controleagricola.funcionario;

import java.sql.Date;
import java.time.LocalDate;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroFuncionario(
		
		int secao,
		
		String descricaoSecao,
		
		Funcao funcao,
		
		Tipo tipo,
		
		int turma,
		
		@Valid
		@NotBlank
		String nome,
		
		LocalDate dataNascimento,
		
		String cpf,
		
		String ctps,
		
		Date admissao,
		
		Date demissao,
		
		String pis
		) {

}
