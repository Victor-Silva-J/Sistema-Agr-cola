package com.gestaoagricola.controleagricola.apontamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gestaoagricola.controleagricola.funcionario.Funcionario;
import com.gestaoagricola.controleagricola.servico.Servico;
import com.gestaoagricola.controleagricola.talhao.Talhao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "apontamentos")
@Data
public class Apontamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Data é obrigatória.")
	private LocalDate data;
	
	@NotNull(message = "Safra é obrigatória.")
	private String safra;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id", nullable = false)
	@NotNull(message = "Funcionário é obrigatório.")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "codigo_servico", nullable = false)
	@NotNull(message = "Serviço é obrigatório")
	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name = "codigo_talhao", nullable = false)
	@NotNull(message = "Talhão é obrigatório.")
	private Talhao talhao;
	
	@DecimalMin(value = "0.0", inclusive = true, message = "Cubagem não pode ser negativo.")
	@Digits(integer = 10, fraction = 2, message = "Cubagem deve ter no máximo 2 casas")
	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal cubagem;
	
	@DecimalMin(value = "0.0", inclusive = true, message = "Tarefa não pode ser negativo.")
	@Digits(integer = 4, fraction = 2, message = "Tarefa deve ter no máximo 2 casas.")
	@Column(precision = 4, scale = 2, nullable = true)
	private BigDecimal tarefa;
}
