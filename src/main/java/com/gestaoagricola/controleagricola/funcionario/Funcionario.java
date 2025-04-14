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
		this.secao = dados.secao();
		this.descricaoSecao = dados.descricaoSecao();
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
	
	
}
