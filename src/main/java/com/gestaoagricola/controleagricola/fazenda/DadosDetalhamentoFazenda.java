package com.gestaoagricola.controleagricola.fazenda;

public record DadosDetalhamentoFazenda(
		Long id, 
		String codigoFazenda, 
		String nome, 
		String municipio, 
		Long cep) {
public DadosDetalhamentoFazenda(Fazenda fazenda) {
	this(
			fazenda.getId(),
			fazenda.getCodigoFazenda(),
			fazenda.getNomeFazenda(),
			fazenda.getMunicipio(),
			fazenda.getCep());
	}
	
}
