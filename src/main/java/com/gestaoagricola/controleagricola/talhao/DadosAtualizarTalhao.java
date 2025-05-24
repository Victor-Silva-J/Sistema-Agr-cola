package com.gestaoagricola.controleagricola.talhao;

import java.math.BigDecimal;

import com.gestaoagricola.controleagricola.fazenda.Fazenda;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTalhao(
		@NotNull
		Long id,
		String numeroTalhao,
		String codigo,
		BigDecimal area,
		Cultura cultura,
		String tipoSolo,
		Fazenda fazenda) {


}
