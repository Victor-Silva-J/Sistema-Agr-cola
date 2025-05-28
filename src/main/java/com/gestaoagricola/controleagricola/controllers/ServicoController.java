package com.gestaoagricola.controleagricola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gestaoagricola.controleagricola.servico.DadosAtualizarServico;
import com.gestaoagricola.controleagricola.servico.DadosCadastroServico;
import com.gestaoagricola.controleagricola.servico.DadosDetalhamentoServico;
import com.gestaoagricola.controleagricola.servico.DadosListagemServico;
import com.gestaoagricola.controleagricola.servico.Servico;
import com.gestaoagricola.controleagricola.servico.ServicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	ServicoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoServico> cadastrarServico(@Valid @RequestBody DadosCadastroServico dados, UriComponentsBuilder uriBuilder){
	
		var servico = new Servico(dados);
		repository.save(servico);
		
		var uri = uriBuilder.path("/servico/{id}").buildAndExpand(servico.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoServico(servico));
		
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemServico>> listarServico(){
		
		var lista = repository.findAll().stream().map(DadosListagemServico::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoServico> atualizarServico(@Validated @RequestBody DadosAtualizarServico dados){
		
	var servico = repository.getReferenceById(dados.id());
	servico.AtualizarServico(dados);
	
	return ResponseEntity.ok(new DadosDetalhamentoServico(servico));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluirServico(@PathVariable Long id){
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
