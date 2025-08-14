package com.gestaoagricola.controleagricola.estoque;

import com.gestaoagricola.controleagricola.funcionario.Tipo;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProduto(
		@NotBlank
		String nome,
		@NotBlank
		Tipo tipo,
		@NotBlank
		Double quantidadeAtual,
		@NotBlank
		UnidadeMedida unidadeMedida) {

}
