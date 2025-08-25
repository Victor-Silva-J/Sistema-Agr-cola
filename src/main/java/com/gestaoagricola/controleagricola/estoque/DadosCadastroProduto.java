package com.gestaoagricola.controleagricola.estoque;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
		@NotBlank
		String nome,
		@NotNull
		TipoProduto tipo,
		@NotNull
		Double quantidadeAtual,
		@NotNull
		UnidadeMedia unidadeMedia) {

}
