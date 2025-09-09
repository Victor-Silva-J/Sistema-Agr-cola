package com.gestaoagricola.controleagricola.talhao;

import java.math.BigDecimal;

import com.gestaoagricola.controleagricola.fazenda.Fazenda;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTalhao(
		
		@NotBlank
		String codigoFazenda,
		
		BigDecimal area,
		
		Cultura cultura,
		
		String tipoSolo,
		
		String numeroTalhao
) {

}
