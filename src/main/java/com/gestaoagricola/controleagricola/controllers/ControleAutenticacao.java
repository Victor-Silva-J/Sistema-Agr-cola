package com.gestaoagricola.controleagricola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoagricola.controleagricola.infra.seguranca.ServicoToken;
import com.gestaoagricola.controleagricola.user.DadosAutenticacao;
import com.gestaoagricola.controleagricola.user.DadosRegistro;
import com.gestaoagricola.controleagricola.user.LoginResponseDTO;
import com.gestaoagricola.controleagricola.user.User;
import com.gestaoagricola.controleagricola.user.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class ControleAutenticacao {
	
	@Autowired
	private ServicoToken tokenService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository repository;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados) {
		var senhaUsuario = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
		var auth = 	this.authenticationManager.authenticate(senhaUsuario);
	
		var token = tokenService.generateToken((User)auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/registrar")
	public ResponseEntity registrar(@RequestBody @Valid DadosRegistro dados) {
		if(this.repository.findByLogin(dados.login()) != null) return ResponseEntity.badRequest().build();

		String senhaCriptografada = new BCryptPasswordEncoder().encode(dados.password());
		User novoUsuario = new User(dados.login(), senhaCriptografada, dados.role());
	
		this.repository.save(novoUsuario);
		
		return ResponseEntity.ok().build();
	}
	
}
