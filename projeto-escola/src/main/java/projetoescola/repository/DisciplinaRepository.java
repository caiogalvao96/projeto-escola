package projetoescola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projetoescola.model.Disciplina;


public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	@Query("select d from Disciplina d where d.nomeDisc like %?1%")
	List<Disciplina> findDisciplinaByNomeLike(String nome);
	
	

}
