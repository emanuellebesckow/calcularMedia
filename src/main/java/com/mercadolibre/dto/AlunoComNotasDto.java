package com.mercadolibre.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mercadolibre.entity.AlunoComNotas;
import com.mercadolibre.entity.Disciplina;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AlunoComNotasDto implements Serializable{
	
	private static final long serialVersionUID = -4857902273326995245L;

	
	
	@NotNull
	@NotEmpty(message = "nome é obrigatório")
	@Size(min = 3, message = "tamanho minimo 3")
	String nome;
	List<Disciplina> disciplinas;	
	
	public static AlunoComNotas converte(AlunoComNotasDto dto) {
		AlunoComNotas aluno = new AlunoComNotas(dto.getNome(), dto.getDisciplinas());				
		return aluno;
	}

}
