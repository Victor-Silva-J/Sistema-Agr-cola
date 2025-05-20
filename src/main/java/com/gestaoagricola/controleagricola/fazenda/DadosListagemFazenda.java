package com.gestaoagricola.controleagricola.fazenda;

public record DadosListagemFazenda(
		String codigofazenda,
		String nomeFazenda,
		String municipio,
		Long cep) {
	
	public DadosListagemFazenda(Fazenda fazenda) {
		this(fazenda.getCodigoFazenda(), fazenda.getNomeFazenda(), fazenda.getMunicipio(), fazenda.getCep());
	}
}
