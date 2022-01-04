package meli.br.com.bootcamp.obterDiploma.DTO;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.mercadolibre.entity.Disciplina;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObterDiplomaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	String nome;
	Disciplina[] disciplinas;
		
}
