package com.gestaoagricola.controleagricola.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.gestaoagricola.controleagricola.funcionario.DadosAtualizarFuncionario;
import com.gestaoagricola.controleagricola.funcionario.DadosCadastroFuncionario;
import com.gestaoagricola.controleagricola.funcionario.DadosDetalhamentoFuncionario;
import com.gestaoagricola.controleagricola.funcionario.DadosListagemFuncionario;
import com.gestaoagricola.controleagricola.funcionario.Funcionario;
import com.gestaoagricola.controleagricola.funcionario.funcionarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	private funcionarioRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrarFuncionario(@RequestBody @Validated DadosCadastroFuncionario dados) {
		var funcionario = new Funcionario(dados);		
		repository.save(funcionario);
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemFuncionario>> listar() {
		var lista = repository.findAll().stream().map(DadosListagemFuncionario::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoFuncionario> atualizar(@RequestBody @Valid DadosAtualizarFuncionario dados){
		var funcionario = repository.getReferenceById(dados.id());
		funcionario.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoFuncionario (funcionario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoFuncionario> detalhar(@PathVariable Long id){
		var funcionario = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
	}
}













