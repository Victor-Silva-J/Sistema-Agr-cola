package com.gestaoagricola.controleagricola.talhao;

import java.math.BigDecimal;

import com.gestaoagricola.controleagricola.fazenda.Fazenda;

public record DadosListagemTalhao(
		Long id,
		String numeroTalhao,
		String codigo,
		BigDecimal area,
		Cultura cultura,
		String tipoSolo) {
	
	public DadosListagemTalhao(Talhao talhao) {
		this(talhao.getId(), 
				talhao.getNumeroTalhao(), 
				talhao.getCodigo(),
				talhao.getArea(),
				talhao.getCultura(), 
				talhao.getTipoSolo());
	}

}
