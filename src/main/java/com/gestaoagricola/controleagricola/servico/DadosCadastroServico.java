package com.gestaoagricola.controleagricola.servico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroServico(
		@NotBlank
		String codigoServico,
		@NotBlank
		String descricao,
		@NotBlank
		String centroCusto) {

}
