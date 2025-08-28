package com.gestaoagricola.controleagricola.estoque;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto(
		
		@NotNull
		Long id,
		String nome,
		TipoProduto tipo,
		Double quantidadeAtual,
		UnidadeMedia unidadeMedia) {
	
}