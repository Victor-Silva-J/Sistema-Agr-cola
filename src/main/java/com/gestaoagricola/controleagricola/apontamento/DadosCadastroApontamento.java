package com.gestaoagricola.controleagricola.apontamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroApontamento(
		@NotNull
		Long funcionario_id,
		@NotBlank
		String codigo_servico,
		@NotBlank
		String codigoTalhao,
		
		@NotBlank
		String safra,
		
		BigDecimal tarefa,
		BigDecimal cubagem,
		
		@NotNull
		String data
		) {

}
