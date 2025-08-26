package com.gestaoagricola.controleagricola.estoque;

public record DadosListagemProduto(
		Long id,
		String nome,
		TipoProduto tipo,
		Double quantidadeAtual,
		UnidadeMedia unidadeMedia) {
	
	public DadosListagemProduto(Produto produto) {
		this(produto.getId(), produto.getNome(), produto.getTipo(), produto.getQuantidadeAtual(), produto.getUnidadeMedia());
	}

}
