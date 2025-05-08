package com.gestaoagricola.controleagricola.fazenda;

public record DadosListagemFazenda(
		int codigofazenda,
		String nome,
		String municipio,
		Long cep) {
	
	public DadosListagemFazenda(Fazenda fazenda) {
		this(fazenda.getCodigoFazenda(), fazenda.getNome(), fazenda.getMunicipio(), fazenda.getCep());
	}
}
