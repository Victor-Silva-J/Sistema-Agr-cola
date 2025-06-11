package com.gestaoagricola.controleagricola.apontamento;

import java.math.BigDecimal;

import com.gestaoagricola.controleagricola.funcionario.Funcionario;
import com.gestaoagricola.controleagricola.talhao.Talhao;

public record DadosListagemApontamento(
		Long id,
		String data,
		String safra,
		String funcionario,
		String talhao,
		BigDecimal cubagem,
		BigDecimal tarefa) {

	public DadosListagemApontamento(Apontamento apontamento) {
		
		this(apontamento.getId(),
				apontamento.getData(),
				apontamento.getSafra(),
				apontamento.getFuncionario().getNome(),
				apontamento.getTalhao().getCodigo(),
				apontamento.getCubagem(),
				apontamento.getTarefa());
	}
}
