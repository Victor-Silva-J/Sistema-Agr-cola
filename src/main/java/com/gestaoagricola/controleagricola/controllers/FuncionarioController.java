package com.gestaoagricola.controleagricola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestaoagricola.controleagricola.funcionario.DadosCadastroFuncionario;
import com.gestaoagricola.controleagricola.funcionario.Funcionario;
import com.gestaoagricola.controleagricola.funcionario.funcionarioRepository;

import jakarta.transaction.Transactional;

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
}