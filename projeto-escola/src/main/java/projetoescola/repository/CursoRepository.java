package projetoescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoescola.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
