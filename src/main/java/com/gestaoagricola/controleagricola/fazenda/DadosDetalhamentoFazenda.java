package com.gestaoagricola.controleagricola.fazenda;

public record DadosDetalhamentoFazenda(
		Long id, 
		int codigoFazenda, 
		String nome, 
		String municipio, 
		Long cep) {
public DadosDetalhamentoFazenda(Fazenda fazenda) {
	this(
			fazenda.getId(),
			fazenda.getCodigoFazenda(),
			fazenda.getNome(),
			fazenda.getMunicipio(),
			fazenda.getCep());
	}
	
}
