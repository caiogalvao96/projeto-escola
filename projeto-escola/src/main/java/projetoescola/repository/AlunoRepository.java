package projetoescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoescola.model.Aluno;

public interface AlunoRepository  extends JpaRepository<Aluno, Long>{

}
