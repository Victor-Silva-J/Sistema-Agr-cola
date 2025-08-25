package com.gestaoagricola.controleagricola.estoque;


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

@Entity(name = "Produto")
@Table(name = "estoque")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	
	public Produto(DadosCadastroProduto dados) {
		this.nome = dados.nome();
		this.tipo = dados.tipo();
		this.quantidadeAtual = dados.quantidadeAtual();
		this.unidadeMedia = dados.unidadeMedia();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private TipoProduto tipo;
	
	@Column(name = "quantidadeAtual")
	private Double quantidadeAtual;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "unidadeMedia")
	private UnidadeMedia unidadeMedia;

}
