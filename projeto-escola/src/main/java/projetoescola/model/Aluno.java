package projetoescola.model;



import java.util.ArrayList; 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.aluno", cascade = CascadeType.ALL)
	private Set<Matricula> matriculas = new HashSet<>();
	
	@JsonIgnore
	public List <Turma> getTrumas(){
		List<Turma> lista = new ArrayList<>();
		for(Matricula x : matriculas) {
			lista.add(x.getTurma());
		}
		return lista;
	}
}
