package com.gestaoagricola.controleagricola.fazenda;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarFazenda(
		
		@NotNull
		Long id,
		String codigoFazenda,
		String nomeFazenda,
		String municipio,
		Long cep) {

}
