package projetoescola.controller;



import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projetoescola.model.Aluno;
import projetoescola.model.Curso;
import projetoescola.model.Disciplina;
import projetoescola.model.Matricula;
import projetoescola.model.Turma;
import projetoescola.objetosDTO.matriculaDTO;
import projetoescola.repository.AlunoRepository;
import projetoescola.repository.CursoRepository;
import projetoescola.repository.DisciplinaRepository;
import projetoescola.repository.MatriculaRepository;
import projetoescola.repository.TurmaRepository;



@RestController
@RequestMapping(value = "/projeto-escola-api")
public class IndexController {
	
	

	@Autowired
    private CursoRepository cursoRepository;
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	
	

	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<String> teste() {
		
		return new ResponseEntity<String>("Hello world!!", HttpStatus.OK);
	}
	

	
	
	@GetMapping(value = "/dcps", produces = "application/json")
	public ResponseEntity<List<Disciplina>> disciplinas() {
		
		List<Disciplina> d = disciplinaRepository.findAll();
		
		return new ResponseEntity<List<Disciplina>>(d, HttpStatus.OK);
	}
	
	
	@DeleteMapping
	@ResponseBody
	public ResponseEntity<String> deletaMatricula(@RequestParam Long idMatricula){
		
		return new ResponseEntity<String>("Deletado com sucesso!", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	


}
