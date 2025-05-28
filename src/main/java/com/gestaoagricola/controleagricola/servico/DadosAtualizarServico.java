package com.gestaoagricola.controleagricola.servico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarServico(
		@NotNull
		Long id,
		String codigoServico,
		String descricao,
		String centroCusto) {

}
