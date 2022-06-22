package projetoescola.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
    @ManyToMany(mappedBy = "alunos")
	private List<Turma> alunoTurma = new ArrayList<Turma>();

}
