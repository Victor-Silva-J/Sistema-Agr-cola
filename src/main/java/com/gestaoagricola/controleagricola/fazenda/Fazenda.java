package com.gestaoagricola.controleagricola.fazenda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "fazenda")
@Table(name = "Fazenda")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Fazenda {

	public Fazenda(DadosCadastroFazenda dados) {
		this.codigoFazenda = dados.codigoFazenda();
		this.nome = dados.nome();
		this.municipio = dados.municipio();
		this.cep = dados.cep();
	}
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long id;
	
	@NotNull
	@Column(name = "CODIGOFAZENDA")
	Integer codigoFazenda;
	@NotNull
	String nome;
	
	String municipio;
	Long cep;
	
	public void atualizarInformacoes(@Valid DadosAtualizarFazenda dados) {
		if(dados.id() != null) {
			this.id = dados.id();
		}
		if(dados.codigoFazenda() != null) {
			this.codigoFazenda = dados.codigoFazenda();
		}
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.municipio() != null) {
			this.municipio = dados.municipio();
		}
		if(dados.cep() != null) {
			this.cep = dados.cep();
		}
		
	}
	
	
}
