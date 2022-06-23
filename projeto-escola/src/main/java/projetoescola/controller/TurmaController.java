package projetoescola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping(value = "/buscaturma", produces = "application/json")
	public ResponseEntity<List<Turma>>buscaturma(){
		
		List<Turma> lista = turmaRepository.findAll();
		
		return new ResponseEntity<List<Turma>>(lista, HttpStatus.OK);
	}
	
	@PutMapping(value = "/atualizaturma")
	public ResponseEntity<Turma> atualizaTurma(@RequestBody Turma turma){
		
		Turma retorno = turmaRepository.saveAndFlush(turma);
		
		return new ResponseEntity<Turma>(retorno, HttpStatus.OK);
	}

}
