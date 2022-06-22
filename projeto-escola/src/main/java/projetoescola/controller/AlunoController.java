package projetoescola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetoescola.model.Aluno;
import projetoescola.repository.AlunoRepository;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	
	@PostMapping(value = "/alunograva", produces = "application/json")
	public ResponseEntity<String>gravarAluno(@RequestBody Aluno aluno){
		
		alunoRepository.save(aluno);
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscaalunos", produces = "application/json")
	public ResponseEntity<List<Aluno>> buscaAlunos(){
		
		List<Aluno> lista = alunoRepository.findAll();
		
		return new ResponseEntity<List<Aluno>>(lista, HttpStatus.OK);
	}

}
