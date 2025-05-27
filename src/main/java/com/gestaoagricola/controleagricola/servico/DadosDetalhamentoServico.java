package com.gestaoagricola.controleagricola.servico;

public record DadosDetalhamentoServico(
		Long id,
		String codigoServico,
		String descricao,
		String centroCusto) {

	public DadosDetalhamentoServico(Servico servico) {
		this(servico.getId(),
				servico.getCodigoServico(), 
				servico.getDescricao(), 
				servico.getCentroCusto());
	}
}
