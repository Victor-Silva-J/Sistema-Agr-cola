package com.gestaoagricola.controleagricola.funcionario;

import java.sql.Date;
import java.time.LocalDate;

public record DadosDetalhamentoFuncionario(
		Long id,
		String nome,
		int secao,
		String descricaoSecao,
		Funcao funcao,
		Tipo tipo,
		int turma,
		LocalDate dataNascimento,
		String cpf,
		String ctps,
		Date demissao,
		Date admissao,
		String pis,
		Boolean ativo) {
	
	public DadosDetalhamentoFuncionario(Funcionario funcionario) {
		this(
				funcionario.getId(),
				funcionario.getNome(),
				funcionario.getSecao(),
				funcionario.getDescricaoSecao(),
				funcionario.getFuncao(),
				funcionario.getTipo(),
				funcionario.getTurma(),
				funcionario.getDataNascimetno(),
				funcionario.getCpf(),
				funcionario.getCtps(),
				funcionario.getDemissao(),
				funcionario.getAdmissao(),
				funcionario.getPis(),
				funcionario.getAtivo());
	}
}
