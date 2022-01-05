package com.mercadolibre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.entity.AlunoComNotas;
import com.mercadolibre.entity.Disciplina;
import com.mercadolibre.repository.AlunoRepository;

@Service
public class ObterDiplomaService {
	
	@Autowired
	AlunoRepository repository;

	
	
//	É necessário desenvolver uma API que receba um aluno que contenha o seu "nome",
//	e todas as disciplinas aprovadas com "nome" e "nota", é necessário calcular a média
//	das notas obtidas ao longo do curso e gerar o diploma com uma “mensagem”,
//	“média” e “aluno”.
//	Se a média do aluno for superior a 9, deve ser reconhecido com um parabéns.
//	
	
	
	public String obterDiploma(Long id) {
		AlunoComNotas aluno = repository.getById(id);
		double media = calcularMedia(aluno);
		if (media < 7) {
			return "Sinto Muito, você está em recuperação";
		}
		if (media >= 7 && media < 9) {
			return "Você Passou";
		}
		if (media >= 9) {
			return "Parabéns, Você é Incrível!!!!";
		}
		
		return null;
	}

	private double calcularMedia(AlunoComNotas aluno) {
		List<Disciplina> notas = aluno.getDisciplinas();
		double notasTotal = 0;
		int quantidadeNotas = 0;
		for (Disciplina disciplina : notas) {
			notasTotal += disciplina.getNota();
			quantidadeNotas ++;
		}
		double media = (notasTotal/quantidadeNotas);
		return media;
//		return 0;
	}

	public AlunoComNotas createAluno(AlunoComNotas aluno) {
		return repository.save(aluno);		
	}

}
