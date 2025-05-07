package com.gestaoagricola.controleagricola.fazenda;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroFazenda(
		@NotBlank
		int codigoFazenda,
		@NotBlank
		String nome,
		String municipio, 
		Long cep) {
	

}
