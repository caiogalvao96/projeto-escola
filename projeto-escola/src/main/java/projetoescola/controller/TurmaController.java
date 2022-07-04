package projetoescola.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projetoescola.model.Turma;
import projetoescola.repository.TurmaRepository;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	/*Manipulando dados da turma*/
	@PostMapping(value = "/turmagrava", produces = "application/json")
	public ResponseEntity<String>gravarTurma(@RequestBody Turma turma){
		
		turmaRepository.save(turma);
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizaturma")
	public ResponseEntity<Turma> atualizaTurma(@RequestBody Turma turma){
		
		Turma retorno = turmaRepository.saveAndFlush(turma);
		
		return new ResponseEntity<Turma>(retorno, HttpStatus.OK);
	}
	
	@GetMapping(value = "/turma", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Optional<Turma>> matricula(@RequestParam Long idTurma){
		
		Optional<Turma> t = turmaRepository.findById(idTurma);
		
		return new ResponseEntity<Optional<Turma>>(t, HttpStatus.OK);
	}
	
	@GetMapping(value = "/turmas", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Turma>> turmas(){
		
		List<Turma> turmas = turmaRepository.findAll();
		
		return new ResponseEntity<List<Turma>>(turmas, HttpStatus.OK);
	}
	
}
