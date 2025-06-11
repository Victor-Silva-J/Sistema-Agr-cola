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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "apontamentos")
@Data
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Apontamento {
	
	public Apontamento(DadosCadastroApontamento dados, Talhao talhao, Servico servico, Funcionario funcionario) {
        this.data = dados.data();
        this.safra = dados.safra();
        this.cubagem = dados.cubagem();
        this.tarefa = dados.tarefa();
        this.talhao = talhao;
        this.servico = servico;
        this.funcionario = funcionario;
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Data é obrigatória.")
	@Column(name = "data_")
	private String data;
	
	@NotNull(message = "Safra é obrigatória.")
	@Column(name = "safra")
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
	@JoinColumn(name = "numero_talhao", nullable = false)
	@NotNull(message = "Talhão é obrigatório.")
	private Talhao talhao;
	
	@DecimalMin(value = "0.0", inclusive = true, message = "Cubagem não pode ser negativo.")
	@Digits(integer = 10, fraction = 2, message = "Cubagem deve ter no máximo 2 casas")
	@Column(name = "cubagem",precision = 10, scale = 2, nullable = true)
	private BigDecimal cubagem;
	
	@DecimalMin(value = "0.0", inclusive = true, message = "Tarefa não pode ser negativo.")
	@Digits(integer = 4, fraction = 2, message = "Tarefa deve ter no máximo 2 casas.")
	@Column(name = "tarefa",precision = 4, scale = 2, nullable = true)
	private BigDecimal tarefa;
}
