package com.gestaoagricola.controleagricola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gestaoagricola.controleagricola.estoque.DadosCadastroProduto;
import com.gestaoagricola.controleagricola.estoque.DadosDetalhamentoProduto;
import com.gestaoagricola.controleagricola.estoque.DadosListagemProduto;
import com.gestaoagricola.controleagricola.estoque.Produto;
import com.gestaoagricola.controleagricola.estoque.RepositoryEstoque;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private RepositoryEstoque repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoProduto> cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder){
		var produto = new Produto(dados);
		repository.save(produto);
		
		var uri = uriBuilder.path("/estoque/{id}").buildAndExpand(produto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
		
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemProduto>> lista(){
		
		var lista = repository.findAll().stream().map(DadosListagemProduto:: new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
