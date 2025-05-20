package com.gestaoagricola.controleagricola.fazenda;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFazenda(
		@NotNull
		String codigoFazenda,
		@NotBlank
		String nomeFazenda,
		String municipio, 
		Long cep) {
	

}
