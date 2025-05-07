package com.gestaoagricola.controleagricola.fazenda;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "fazenda")
@Table(name = "Fazendas")
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
	
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long id;
	
	@NotNull
	int codigoFazenda;
	@NotNull
	String nome;
	
	String municipio;
	Long cep;
	
	
	
}
