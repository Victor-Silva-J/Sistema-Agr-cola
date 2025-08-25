package com.gestaoagricola.controleagricola.estoque;


public record DadosDetalhamentoProduto(
		Long id,
		String nome,
		TipoProduto tipo,
		Double quantidadeAtual,
		UnidadeMedia unidadeMedia) {
	
		public DadosDetalhamentoProduto(Produto produto) {
			this(
			produto.getId(),
			produto.getNome(),
			produto.getTipo(),
			produto.getQuantidadeAtual(),
			produto.getUnidadeMedia());
		}

}
