package com.gestaoagricola.controleagricola.funcionario;

import java.sql.Date;
import java.time.LocalDate;

public record DadosListagemFuncionario(
		Long id,
		String nome,
		String descricaoSecao,
		Funcao funcao,
		Tipo tipo,
		int Turma,
		LocalDate dataNascimento,
		String cpf,
		String ctps,
		Date admissao,
		Date demissao,
		String pis,
		boolean ativo
		
		) {
	public DadosListagemFuncionario(Funcionario funcionario) {
		this(funcionario.getId(), funcionario.getNome(), funcionario.getDescricaoSecao(), funcionario.getFuncao(), funcionario.getTipo(),
				funcionario.getTurma(), funcionario.getDataNascimetno(), funcionario.getCpf(),funcionario.getCtps(), funcionario.getAdmissao(),
				funcionario.getDemissao(), funcionario.getPis(), funcionario.getAtivo());
	}
	
	}
