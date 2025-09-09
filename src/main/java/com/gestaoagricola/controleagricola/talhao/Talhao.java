package com.gestaoagricola.controleagricola.talhao;

import java.math.BigDecimal;

import com.gestaoagricola.controleagricola.fazenda.Fazenda;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "talhao")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Talhao {
	
	public Talhao(DadosCadastroTalhao dados, Fazenda fazenda) {
		this.codigo = dados.codigoFazenda() + dados.numeroTalhao();
		this.numeroTalhao = dados.numeroTalhao();
		this.area = dados.area();
		this.cultura = dados.cultura();
		this.tipoSolo = dados.tipoSolo();
		this.fazenda = fazenda;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "numero_talhao")
	private String numeroTalhao;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "area")
	private BigDecimal area;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "cultura")
	private Cultura cultura;
	
	@Column(name = "tipo_de_solo")
	private String tipoSolo;
	
	@ManyToOne(fetch = FetchType.LAZY.EAGER)
	@JoinColumn(name = "codigo_fazenda",referencedColumnName = "codigoFazenda", nullable = false)
	private Fazenda fazenda;
	
	 public String getNomeFazenda() {
	        return fazenda != null ? fazenda.getNomeFazenda() : null;
	    }
	
	public void atualizarInformacoes(DadosAtualizarTalhao dados) {
		if(dados.numeroTalhao() != null) {
			this.numeroTalhao = dados.numeroTalhao();
		}
		if(dados.codigo() != null) {
			this.codigo = dados.codigo();
		}
		if(dados.area() != null) {
			this.area = dados.area();
		}
		if(dados.cultura() != null) {
			this.cultura = dados.cultura();
		}
		if(dados.tipoSolo() != null) {
			this.tipoSolo = dados.tipoSolo();
		}
	}
	
}
