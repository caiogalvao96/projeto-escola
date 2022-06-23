package projetoescola.model;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String sigla;
	
	@OneToOne
	private Curso curso;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "matricula", 
	        joinColumns =  @JoinColumn(name = "turma_id"),
	        inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	

}
