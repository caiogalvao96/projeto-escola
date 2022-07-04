package projetoescola;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import projetoescola.model.Aluno;
import projetoescola.model.Curso;
import projetoescola.model.Disciplina;
import projetoescola.model.Matricula;
import projetoescola.model.Turma;
import projetoescola.repository.AlunoRepository;
import projetoescola.repository.CursoRepository;
import projetoescola.repository.DisciplinaRepository;
import projetoescola.repository.MatriculaRepository;
import projetoescola.repository.TurmaRepository;

@SpringBootApplication
@EntityScan(basePackages = {"projetoescola.model"})
@ComponentScan(basePackages = {"projetoescola.*", "projetoescola"})
@EnableJpaRepositories(basePackages = {"projetoescola.repository"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class ProjetoEscolaApplication implements CommandLineRunner {
	
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private MatriculaRepository matriculaRepository;
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEscolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Curso curso1 = new Curso();
		curso1.setNomeCurso("Banco de dados");
		
		cursoRepository.save(curso1);
		
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Andre");
		aluno1.setSobrenome("Mane");
		aluno1.setRg("459039921");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("gustavo");
		aluno2.setSobrenome("Mexico");
		aluno2.setRg("442315621");
		
		alunoRepository.saveAll(Arrays.asList(aluno1,aluno2));
		*/
		
		/*
		Curso curso = cursoRepository.findById(39L).get();
		
		Turma turma1 = new Turma();
		turma1.setSigla("A");
		turma1.setCurso(curso);
		
		Turma turma2 = new Turma();
		turma2.setSigla("B");
		turma2.setCurso(curso);
		
		turmaRepository.saveAll(Arrays.asList(turma1, turma2));
		*/
		
		/*
		Aluno al1 = alunoRepository.findById(40L).get();
		Aluno al2 = alunoRepository.findById(41L).get();
		Aluno al3 = alunoRepository.findById(44L).get();
		Aluno al4 = alunoRepository.findById(45L).get();
		
		Turma t1 = turmaRepository.findById(42L).get();
		Turma t2 = turmaRepository.findById(43L).get();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date data = formato.parse("2022-06-23");
		
		Matricula m1 = new Matricula(al1, t1, data);
		Matricula m2 = new Matricula(al2, t1, data);
		Matricula m3 = new Matricula(al3, t2, data);
		Matricula m4 = new Matricula(al4, t2, data);
		
		matriculaRepository.saveAll(Arrays.asList(m1,m2,m3,m4));
		
		al1.getMatriculas().addAll(Arrays.asList(m1));
		al2.getMatriculas().addAll(Arrays.asList(m1));
		
		al3.getMatriculas().addAll(Arrays.asList(m2));
		al4.getMatriculas().addAll(Arrays.asList(m2));
		
		t1.getMatriculas().addAll(Arrays.asList(m1,m2));
		t2.getMatriculas().addAll(Arrays.asList(m3,m4));
		
		alunoRepository.saveAll(Arrays.asList(al1,al2,al3,al4));
		
		turmaRepository.saveAll(Arrays.asList(t1, t2));
		
		//System.out.println("Turma ...: "+t1.getSigla()+"\n"+t1.getAlunos());
		*/
		
		/*
		Aluno al1 = alunoRepository.findById(40L).get();
		
		Turma t = turmaRepository.findById(43L).get();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Date data = formato.parse("2022-06-30");
	    
		Matricula m = new Matricula(al1, t, data);
		
		matriculaRepository.save(m);
		*/
		
		/*
		
		Disciplina d = new Disciplina();
		Curso c = cursoRepository.findById(39L).get();
		
		d.setNomeDisc("Modelagem de dados");
		d.setHoraAula(250);
		d.getCursos().addAll(Arrays.asList(c));
		
		
		
		disciplinaRepository.save(d);
		
		 */
		
		
		/*
		Disciplina d = disciplinaRepository.findById(59L).get();
		Curso c = new Curso();
		
		c = cursoRepository.findById(39L).get();
		
		d.getCursos().addAll(Arrays.asList(c));
		
		disciplinaRepository.save(d);
		*/
		
		/*
		Curso curso = cursoRepository.findById(39L).get();
		
		Disciplina d = disciplinaRepository.findById(65L).get();
		
		curso.getDisciplinas().addAll(Arrays.asList(d));
		
		cursoRepository.save(curso);
		*/
	
		
		
		
		
		
		
		/*
		Disciplina disc = disciplinaRepository.findById(60L).get();
		
		Curso c = cursoRepository.findById(39L).get();
		
		List<Curso> lista = disc.getCursos();
		
		lista.remove(c);
		
		
		
		disc.setCursos(lista);
		
		disciplinaRepository.save(disc);
		
		*/
		
		/*
		Curso curso = cursoRepository.findById(39L).get();
		
		Disciplina d = disciplinaRepository.findById(65L).get();
		
		List<Disciplina> lista = curso.getDisciplinas();
		
		lista.remove(d);
		
		curso.setDisciplinas(lista);
		
		cursoRepository.save(curso);
		
		*/
		
	}

}
