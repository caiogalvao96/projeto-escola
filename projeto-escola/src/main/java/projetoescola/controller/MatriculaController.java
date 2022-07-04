package projetoescola.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projetoescola.model.Aluno;
import projetoescola.model.Matricula;
import projetoescola.model.Turma;
import projetoescola.objetosDTO.matriculaDTO;
import projetoescola.repository.AlunoRepository;
import projetoescola.repository.MatriculaRepository;
import projetoescola.repository.TurmaRepository;

@RestController
@RequestMapping(value = "/matricula")
public class MatriculaController {

	@Autowired
	private MatriculaRepository matriculaRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private TurmaRepository turmaRepository;
	
	

	@GetMapping(value = "/matriculas", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Matricula>> matriculas(){
		
		List<Matricula> matriculas = matriculaRepository.findAll();
		
		return new ResponseEntity<List<Matricula>>(matriculas, HttpStatus.OK);
	}
	
	@PostMapping(value = "/matricular")
	@ResponseBody
	public ResponseEntity<String> matricula(@RequestBody matriculaDTO m) throws Exception{
		
		
	
	   
		Aluno a = alunoRepository.findById(m.getIdAluno()).get();
		Turma t = turmaRepository.findById(m.getIdTurma()).get();
		

		
	
	    
		Matricula ma = new Matricula(a, t, m.getData());
		
		matriculaRepository.save(ma);
		
		return new ResponseEntity<String>("Matriculado com sucesso!", HttpStatus.OK);
	}
	
	
	
}
