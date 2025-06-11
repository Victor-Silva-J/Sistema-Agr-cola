package com.gestaoagricola.controleagricola.apontamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gestaoagricola.controleagricola.funcionario.Funcionario;
import com.gestaoagricola.controleagricola.servico.Servico;
import com.gestaoagricola.controleagricola.talhao.Talhao;

public record DadosDetalhamentoApontamento(
		String data,
		String safra,
		String funcionario,
		String servico,
		String talhao,
		BigDecimal cubagem,
		BigDecimal tarefa
		) {

	public DadosDetalhamentoApontamento(Apontamento apontamento) {
		this(apontamento.getData(),
				apontamento.getSafra(),
				apontamento.getFuncionario().getNome(),
				apontamento.getServico().getDescricao(),
				apontamento.getTalhao().getCodigo(),
				apontamento.getCubagem(),
				apontamento.getTarefa());
	}
}
