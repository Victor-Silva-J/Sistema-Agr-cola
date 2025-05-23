package com.gestaoagricola.controleagricola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gestaoagricola.controleagricola.fazenda.Fazenda;
import com.gestaoagricola.controleagricola.fazenda.RepositoryFazenda;
import com.gestaoagricola.controleagricola.talhao.DadosCadastroTalhao;
import com.gestaoagricola.controleagricola.talhao.DadosDetalhamentoTalhao;
import com.gestaoagricola.controleagricola.talhao.DadosListagemTalhao;
import com.gestaoagricola.controleagricola.talhao.Talhao;
import com.gestaoagricola.controleagricola.talhao.TalhaoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/talhao")
public class TalhaoController {

	@Autowired
	private TalhaoRepository talhaoRepository;
	
	@Autowired
	private RepositoryFazenda fazendaRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoTalhao> cadastrarTalhao(@Valid @RequestBody DadosCadastroTalhao dados, UriComponentsBuilder uriBuilder){
		var fazenda = fazendaRepository.findByCodigoFazenda(dados.codigoFazenda()).orElseThrow(() -> new RuntimeException("Fazenda com código " + dados.codigoFazenda() + " não encontrada."));
		
		var talhao = new Talhao(dados, fazenda);
		talhaoRepository.save(talhao);
		
		var uri = uriBuilder.path("/talhao/{codigo}").buildAndExpand(talhao.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoTalhao(talhao));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarTalhao(@PathVariable Long id){
		
		talhaoRepository.deleteById(id);
		return ResponseEntity.ok().body("Talhão excluído com sucesso!");
		
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemTalhao>> listarTalhao(DadosListagemTalhao dados){
		var lista = talhaoRepository.findAll().stream().map(DadosListagemTalhao::new).toList();
		return ResponseEntity.ok(lista);
	}
}
