package projetoescola.model;

import java.io.Serializable;    
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;




import lombok.Setter;


@Setter
@Entity
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String sigla;
	
	
	@OneToOne
	private Curso curso;
	
	
	
	@OneToMany(mappedBy = "id.turma")
	private Set<Matricula> matriculas = new HashSet<>();
	


	@JsonIgnore
	public List<Aluno> getAlunos(){
		List<Aluno> lista = new ArrayList<>();
		for(Matricula x : matriculas) {
			lista.add(x.getAluno());
		}
		return lista;
	}

	public Long getId() {
		return id;
	}

	public String getSigla() {
		return sigla;
	}

	public Curso getCurso() {
		return curso;
	}

	
     
	
	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}
    
	
	
   
}
