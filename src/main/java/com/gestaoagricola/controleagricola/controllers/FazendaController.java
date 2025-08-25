package com.gestaoagricola.controleagricola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gestaoagricola.controleagricola.fazenda.DadosAtualizarFazenda;
import com.gestaoagricola.controleagricola.fazenda.DadosCadastroFazenda;
import com.gestaoagricola.controleagricola.fazenda.DadosDetalhamentoFazenda;
import com.gestaoagricola.controleagricola.fazenda.DadosListagemFazenda;
import com.gestaoagricola.controleagricola.fazenda.Fazenda;
import com.gestaoagricola.controleagricola.fazenda.RepositoryFazenda;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {

	@Autowired 
	private RepositoryFazenda repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoFazenda> cadastrarFazenda(@RequestBody @Valid DadosCadastroFazenda dados, UriComponentsBuilder uriBuilder) {
		var fazenda = new Fazenda(dados);
		repository.save(fazenda);
		
		var uri = uriBuilder.path("/fazenda/{codigoFazenda}").buildAndExpand(fazenda.getCodigoFazenda()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoFazenda(fazenda));
	}
	
	@GetMapping
	public ResponseEntity <List<DadosListagemFazenda>> listar(){
		
		var lista = repository.findAll().stream().map(DadosListagemFazenda::new).toList();
		
		return ResponseEntity.ok(lista);
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoFazenda> atualizar(@Valid @RequestBody DadosAtualizarFazenda dados){
		
		var fazenda = repository.getReferenceById(dados.id());
		fazenda.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoFazenda(fazenda));
	}
	
	
}
