package projetoescola.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projetoescola.model.Curso;

import projetoescola.repository.CursoRepository;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {
	
	@Autowired
	CursoRepository cursoRepository;
	
	@GetMapping(value = "/cursos", produces = "application/json")
	public ResponseEntity<List<Curso>> cursos() {
		
		List<Curso> c = cursoRepository.findAll();
		
		return new ResponseEntity<List<Curso>>(c, HttpStatus.OK);
	}
	
    /*Manipulando dados do curso*/
	@PostMapping(value = "/salvar", produces = "application/json")
	public ResponseEntity<String>gravarCurso(@RequestBody Curso curso){
		
		cursoRepository.save(curso);
		
		return new ResponseEntity<String>("Salvo com sucesso!", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletar")
	@ResponseBody
	public ResponseEntity<String> deletaCurso(@RequestParam Long id){
		
		cursoRepository.deleteById(id);
		
		return new ResponseEntity<String>("Deletado com sucesso!", HttpStatus.OK);
	}
	
	

}
