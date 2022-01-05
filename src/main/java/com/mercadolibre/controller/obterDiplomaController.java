package com.mercadolibre.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.dto.AlunoComNotasDto;
import com.mercadolibre.entity.AlunoComNotas;
import com.mercadolibre.service.ObterDiplomaService;


@RestController
@RequestMapping("/obterdiploma")
public class obterDiplomaController {
	
	@Autowired
	ObterDiplomaService service;
	
	@GetMapping("/ping")
	public String meuMetodo() {
		return "pong";
	}
	
	
	
	@GetMapping(value = "/{id}")
//	(produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> obterDiploma(@PathVariable Long id) 
	{
		String retorno = service.obterDiploma(id); 
		return ResponseEntity.ok(retorno);

	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public  ResponseEntity<?> create(@Valid @RequestBody AlunoComNotasDto alunodto) {
		AlunoComNotas aluno = AlunoComNotasDto.converte(alunodto);
		AlunoComNotas result = service.createAluno(aluno);
		return ResponseEntity.ok(result);
	}
	
	
}
