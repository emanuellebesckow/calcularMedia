package com.mercadolibre.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AlunoComNotas implements Serializable{
	
	private static final long serialVersionUID = -5856525040990349495L;	

	public AlunoComNotas(String nome, List<Disciplina> disciplinas) {
		this.nome = nome;
		this.disciplinas = disciplinas;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	String nome;
	@OneToMany(cascade = CascadeType.ALL)
	List<Disciplina> disciplinas;
	
	
	
}

