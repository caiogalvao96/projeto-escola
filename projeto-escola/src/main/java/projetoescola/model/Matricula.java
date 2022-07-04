package projetoescola.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Setter
@Entity
public class Matricula implements Serializable {


	private static final long serialVersionUID = 1L;
	
    @JsonIgnore
	@EmbeddedId
	private MatriculaPK id = new MatriculaPK();
	
	@Temporal(TemporalType.DATE)
	private Date dataMatricula;
	
	
	public Matricula(Aluno aluno, Turma turma, Date dataMatricula) {
		super();
		id.setAluno(aluno);
		id.setTurma(turma);
		this.dataMatricula = dataMatricula;
	}
	
	
	public Matricula() {
		
	}

	
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	@JsonIgnore
	public Turma getTurma() {
		return id.getTurma();
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}
	
	
	public MatriculaPK getId() {
		return id;
	}
	
	

}
