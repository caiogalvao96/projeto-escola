package projetoescola.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class MatriculaPK implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;


	@Override
	public int hashCode() {
		return Objects.hash(aluno, turma);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaPK other = (MatriculaPK) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(turma, other.turma);
	}

	
	
}
