package com.gestaoagricola.controleagricola.talhao;

import java.math.BigDecimal;

import com.gestaoagricola.controleagricola.fazenda.Fazenda;

public record DadosDetalhamentoTalhao(
		Long id,
		String codigo,
		BigDecimal area,
		Cultura cultura,
		String codigoFazenda) {
	
	public DadosDetalhamentoTalhao(Talhao talhao) {
		this(talhao.getId(),
				talhao.getCodigo(),
				talhao.getArea(),
				talhao.getCultura(),
				talhao.getFazenda().getCodigoFazenda()
				);
	}
}
