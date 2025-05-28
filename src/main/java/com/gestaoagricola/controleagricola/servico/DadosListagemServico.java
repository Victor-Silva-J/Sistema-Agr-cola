package com.gestaoagricola.controleagricola.servico;

public record DadosListagemServico(
		Long id,
		String codigoServico,
		String descricao,
		String centroCusto) {

	public DadosListagemServico(Servico servico) {
		
		this(servico.getId(),
				servico.getCodigoServico(),
				servico.getDescricao(),
				servico.getCentroCusto());
	}
}
