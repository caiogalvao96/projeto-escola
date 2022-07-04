package projetoescola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projetoescola.model.Disciplina;
import projetoescola.repository.DisciplinaRepository;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	
	@PostMapping(value = "/salvar", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> saveDisc(@RequestBody Disciplina d){
		
		disciplinaRepository.save(d);
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/atualiza", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> updateDisc(@RequestBody Disciplina d){
		
		disciplinaRepository.save(d);
		
		return new ResponseEntity<String>("Atualizado com sucesso!", HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/deletar")
	@ResponseBody
	public ResponseEntity<String> deletaDisc (@RequestParam Long id){
		
		disciplinaRepository.deleteById(id);
		
		return new ResponseEntity<String>("Deletado com sucesso!", HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/disciplinas")
	@ResponseBody
	public ResponseEntity<List<Disciplina>> buscaTodos(){
		
		List<Disciplina> lista = disciplinaRepository.findAll();
		
		return new ResponseEntity<List<Disciplina>>(lista, HttpStatus.OK);
	}
	

	@GetMapping(value = "/disciplina")
	@ResponseBody
	public ResponseEntity<List<Disciplina>> buscaPorNome(@RequestParam String d){
		
		List<Disciplina> lista = disciplinaRepository.findDisciplinaByNomeLike(d);
		
		return new ResponseEntity<List<Disciplina>>(lista, HttpStatus.OK);
	}

}
