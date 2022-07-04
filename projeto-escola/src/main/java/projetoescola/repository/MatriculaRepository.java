package projetoescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoescola.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
