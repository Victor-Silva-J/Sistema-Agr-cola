package com.gestaoagricola.controleagricola.fazenda;

public record DadosListagemFazenda(
		Long id,
		String codigofazenda,
		String nomeFazenda,
		String municipio,
		Long cep) {
	
	public DadosListagemFazenda(Fazenda fazenda) {
		this(fazenda.getId(), fazenda.getCodigoFazenda(), fazenda.getNomeFazenda(), fazenda.getMunicipio(), fazenda.getCep());
	}
}
