package br.edu.unoesc.desafio_2025_1.controller;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.model.EstudanteCurso;
import br.edu.unoesc.desafio_2025_1.model.Pessoa;
import br.edu.unoesc.desafio_2025_1.service.CursoService;
import br.edu.unoesc.desafio_2025_1.service.EstudanteCursoService;
import br.edu.unoesc.desafio_2025_1.service.PessoaService;
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
@RequestMapping("/estudante")
public class EstudanteCursoController {

    @Autowired
    private EstudanteCursoService estudanteService;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/cadastro")
    public String getEstudantes(@ModelAttribute("estudante") EstudanteCurso estudanteCurso, Model model){
        List<Pessoa> pessoas = pessoaService.obtemListaPessoas();
        model.addAttribute("pessoas", pessoas);
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        return "/cadastros/cadastroEstudante";
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarEstudante(@Validated @ModelAttribute EstudanteCurso estudante, BindingResult result){
        try {
            if(result.hasErrors()){
                Map<String, String> erros = new HashMap<>();
                result.getFieldErrors().forEach(t->{
                    erros.put(t.getField(), t.getDefaultMessage());
                });
                return ResponseEntity.badRequest().body(erros);
            }
            EstudanteCurso estudanteSalvo = estudanteService.cadastrarEstudante(estudante);
            return ResponseEntity.status(HttpStatus.CREATED).body(estudanteSalvo);
        }catch (Exception e){
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Salvar o registro");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

    @GetMapping("/listarDados")
    public String listarDadosEstudante(Model model){
        List<EstudanteCurso> estudantes = estudanteService.obtemListaEstudante();
        model.addAttribute("estudantes", estudantes);
        return "/consultas/consultaEstudante";
    }

    @GetMapping("/editar/{id}")
    public String editarEstudante(@PathVariable("id") Integer id, Model model) {
        List<Pessoa> pessoas = pessoaService.obtemListaPessoas();
        model.addAttribute("pessoas", pessoas);
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        Optional<EstudanteCurso> estudante = estudanteService.buscarPorIdEstudante(id);
        model.addAttribute("estudante", estudante.get());
        return "/cadastros/cadastroEstudante";
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarEstudante(@PathVariable("id") Integer id){
        try {
            estudanteService.deletarEstudante(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Deletar o registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }


}
