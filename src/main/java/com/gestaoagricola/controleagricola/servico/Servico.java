package com.gestaoagricola.controleagricola.servico;

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

@Entity
@Table(name ="servico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Servico {

	public Servico(DadosCadastroServico dados) {
		this.codigoServico = dados.codigoServico();
		this.descricao = dados.descricao();
		this.centroCusto = dados.centroCusto();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoServico;
	private String descricao;
	private String centroCusto;
	
	public void AtualizarServico(DadosAtualizarServico dados) {
		if(dados.codigoServico() != null) {
			this.codigoServico = dados.codigoServico();
		}
		if(dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if(dados.centroCusto() != null) {
			this.centroCusto = dados.centroCusto();
		}
	}
}
