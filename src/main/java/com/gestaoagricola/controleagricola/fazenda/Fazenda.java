package com.gestaoagricola.controleagricola.fazenda;

import java.util.List;

import com.gestaoagricola.controleagricola.talhao.Talhao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Fazenda")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Fazenda {

	public Fazenda(DadosCadastroFazenda dados) {
		this.codigoFazenda = dados.codigoFazenda();
		this.nomeFazenda = dados.nomeFazenda();
		this.municipio = dados.municipio();
		this.cep = dados.cep();
	}
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@NotNull
	@Column(name = "CODIGOFAZENDA", unique = true)
	private String codigoFazenda;
	
	@NotNull
	@Column(name = "FAZENDA")
	private String nomeFazenda;
	
	private String municipio;
	
	private Long cep;
	
	@OneToMany(mappedBy = "fazenda")
	private List<Talhao> talhoes;
	
	public void atualizarInformacoes(@Valid DadosAtualizarFazenda dados) {
		if(dados.id() != null) {
			this.id = dados.id();
		}
		if(dados.codigoFazenda() != null) {
			this.codigoFazenda = dados.codigoFazenda();
		}
		if(dados.nomeFazenda() != null) {
			this.nomeFazenda = dados.nomeFazenda();
		}
		if(dados.municipio() != null) {
			this.municipio = dados.municipio();
		}
		if(dados.cep() != null) {
			this.cep = dados.cep();
		}
		
	}
	
	
}
