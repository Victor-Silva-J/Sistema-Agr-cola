package com.gestaoagricola.controleagricola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gestaoagricola.controleagricola.apontamento.Apontamento;
import com.gestaoagricola.controleagricola.apontamento.ApontamentoRepository;
import com.gestaoagricola.controleagricola.apontamento.DadosCadastroApontamento;
import com.gestaoagricola.controleagricola.apontamento.DadosDetalhamentoApontamento;
import com.gestaoagricola.controleagricola.apontamento.DadosListagemApontamento;
import com.gestaoagricola.controleagricola.funcionario.funcionarioRepository;
import com.gestaoagricola.controleagricola.servico.ServicoRepository;
import com.gestaoagricola.controleagricola.talhao.TalhaoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/apontamento")
public class apontamentoController {
	
	@Autowired
	private ApontamentoRepository apontamentoRepository;

	@Autowired
	private TalhaoRepository talhaoRepository;
	
	@Autowired
	private	ServicoRepository servicoRepository;
	
	@Autowired
	private funcionarioRepository funcionarioRepository;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoApontamento> cadastrarApontamento(@RequestBody @Valid DadosCadastroApontamento dados, UriComponentsBuilder uriBuilder){
		var talhao = talhaoRepository.findByCodigo(dados.codigoTalhao()).orElseThrow(() -> new RuntimeException("Talhão com número " + dados.codigoTalhao() + " não encontrado."));
		var servico = servicoRepository.findByCodigoServico(dados.codigo_servico()).orElseThrow(() -> new RuntimeException("Serviço com código " + dados.codigo_servico() + " não encontrado."));
		var funcionario = funcionarioRepository.findById(dados.funcionario_id()).orElseThrow(() -> new RuntimeException("Funcionário com id " + dados.funcionario_id() + " não encontrado."));
		
		var apontamento = new Apontamento(dados, talhao, servico, funcionario);
		apontamentoRepository.save(apontamento);
		
		var uri = uriBuilder.path("/apontamento/{id}").buildAndExpand(apontamento.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoApontamento(apontamento));
	}
	
	@GetMapping
	public ResponseEntity <List<DadosListagemApontamento>> listarApontamento(){
		
		var lista = apontamentoRepository.findAll().stream().map(DadosListagemApontamento::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluirApontamento(@PathVariable Long id) {
	
		apontamentoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
}
