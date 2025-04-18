package com.gestaoagricola.controleagricola.funcionario;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Funcionario")
@Table(name = "Funcionarios")
public class Funcionario {

	public Funcionario(DadosCadastroFuncionario dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.funcao = dados.funcao();
		this.tipo = dados.tipo();
		this.turma = dados.turma();
		this.nome = dados.nome();
		this.dataNascimetno = dados.dataNascimento();
		this.cpf = dados.cpf();
		this.ctps = dados.ctps();
		this.admissao = dados.admissao();
		this.demissao = dados.demissao();
		this.pis = dados.pis();
		this.secao = dados.secao();
		if (dados.secao() == 10) {
			this.descricaoSecao = "Sossego";
		} else if (dados.secao() == 11) {
			this.descricaoSecao = "Suruagy";
		} else if (dados.secao() == 12) {
			this.descricaoSecao = "Sitio Sossego";
		} else if (dados.secao() == 13) {
			this.descricaoSecao = "Granja Sossego";
		} else if (dados.secao() == 14) {
			this.descricaoSecao = "Água Azul";
		} else if (dados.secao() == 15) {
			this.descricaoSecao = "Nova Vida";
		} else if (dados.secao() == 16) {
			this.descricaoSecao = "Águas Belas";
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "SECAO")
	private int secao;

	@Column(name = "DESCRICAO_DA_SECAO")
	private String descricaoSecao;

	@Column(name = "FUNCAO")
	@Enumerated(EnumType.STRING)
	private Funcao funcao;

	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(name = "TURMA")
	private int turma;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DATA_DE_NASCIMENTO")
	private LocalDate dataNascimetno;

	@Column(name = "CPF")
	private String cpf;

	@Column(name = "CTPS")
	private String ctps;

	@Column(name = "ADMISSAO")
	private Date admissao;

	@Column(name = "DEMISSAO")
	private Date demissao;

	@Column(name = "PIS")
	private String pis;

	private Boolean ativo;

	
	public void atualizarInformacoes(@Valid DadosAtualizarFuncionario dados) {
		if(dados.ativo() != null) {
			this.ativo = dados.ativo();
		}
		if(dados.id() != null) {
			this.id = dados.id();
		}
		if(dados.secao() != null) {
			this.secao = dados.secao();
		}
		if(dados.funcao() != null) {
			this.funcao = dados.funcao();
		}
		if(dados.tipo() != null) {
			this.tipo = dados.tipo();
		}
		if(dados.turma() != null) {
			this.turma = dados.turma();
		}
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.dataNascimento() != null) {
			this.dataNascimetno = dados.dataNascimento();
		}
		if(dados.cpf() != null) {
			this.cpf = dados.cpf();
		}
		if(dados.ctps() != null) {
			this.ctps = dados.ctps();
		}
		if(dados.demissao() != null) {
			this.demissao = dados.demissao();
		}
		if(dados.admissao() != null) {
			this.admissao = dados.admissao();
		}
		if(dados.pis() != null) {
			this.pis = dados.pis();
		}
	}
}
