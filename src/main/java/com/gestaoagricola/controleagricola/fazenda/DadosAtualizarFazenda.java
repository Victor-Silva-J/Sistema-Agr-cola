package com.gestaoagricola.controleagricola.fazenda;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarFazenda(
		
		@NotNull
		Long id,
		Integer codigoFazenda,
		String nome,
		String municipio,
		Long cep) {

}
