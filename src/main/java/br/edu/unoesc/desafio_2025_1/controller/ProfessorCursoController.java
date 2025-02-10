package br.edu.unoesc.desafio_2025_1.controller;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.model.Pessoa;
import br.edu.unoesc.desafio_2025_1.model.ProfessorCurso;
import br.edu.unoesc.desafio_2025_1.service.CursoService;
import br.edu.unoesc.desafio_2025_1.service.PessoaService;
import br.edu.unoesc.desafio_2025_1.service.ProfessorCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/professor")
public class ProfessorCursoController {

    @Autowired
    private ProfessorCursoService professorService;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/cadastro")
    public String getProfessores(@ModelAttribute("professor") ProfessorCurso professorCurso, Model model){
        List<Pessoa> pessoas = pessoaService.obtemListaPessoas();
        model.addAttribute("pessoas", pessoas);
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        return "/cadastros/cadastroProfessor";
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarProfessor(@Validated @ModelAttribute ProfessorCurso professor, BindingResult result){
        try {
            if(result.hasErrors()){
                Map<String, String> erros = new HashMap<>();
                result.getFieldErrors().forEach(t->{
                    erros.put(t.getField(), t.getDefaultMessage());
                });
                return ResponseEntity.badRequest().body(erros);
            }
            ProfessorCurso professorSalvo = professorService.cadastrarProfessor(professor);
            return ResponseEntity.status(HttpStatus.CREATED).body(professorSalvo);
        }catch (Exception e){
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Salvar o registro");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

    @GetMapping("/listarDados")
    public String listarDadosProfessor(Model model){
        List<ProfessorCurso> professores = professorService.obtemListaProfessor();
        model.addAttribute("professores", professores);
        return "/consultas/consultaProfessor";
    }

    @GetMapping("/editar/{id}")
    public String editarProfessor(@PathVariable("id") Integer id, Model model) {
        List<Pessoa> pessoas = pessoaService.obtemListaPessoas();
        model.addAttribute("pessoas", pessoas);
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        Optional<ProfessorCurso> professor = professorService.buscarPorIdProfessor(id);
        model.addAttribute("professor", professor.get());
        return "/cadastros/cadastroProfessor";
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarProfessor(@PathVariable("id") Integer id){
        try {
            professorService.deletarProfessor(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Deletar o registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }
}
