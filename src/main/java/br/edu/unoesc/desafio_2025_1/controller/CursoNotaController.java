package br.edu.unoesc.desafio_2025_1.controller;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.model.CursoNota;
import br.edu.unoesc.desafio_2025_1.model.EstudanteCurso;
import br.edu.unoesc.desafio_2025_1.service.CursoNotaService;
import br.edu.unoesc.desafio_2025_1.service.CursoService;
import br.edu.unoesc.desafio_2025_1.service.EstudanteCursoService;
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
@RequestMapping("/nota")
public class CursoNotaController {

    @Autowired
    private CursoNotaService notaService;
    @Autowired
    private EstudanteCursoService estudanteService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/cadastro")
    public String getNotas(@ModelAttribute("nota") CursoNota nota, Model model){
        List<EstudanteCurso> estudantes = estudanteService.obtemListaEstudante();
        model.addAttribute("estudantes", estudantes);
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        return "/cadastros/cadastroNota";
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarNota(@Validated @ModelAttribute CursoNota nota, BindingResult result){
        try {
            if(result.hasErrors()){
                Map<String, String> erros = new HashMap<>();
                result.getFieldErrors().forEach(t->{
                    erros.put(t.getField(), t.getDefaultMessage());
                });
                return ResponseEntity.badRequest().body(erros);
            }
            CursoNota notaSalva = notaService.cadastrarNota(nota);
            return ResponseEntity.status(HttpStatus.CREATED).body(notaSalva);
        }catch (Exception e){
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Salvar o registro");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

    @GetMapping("/listarDados")
    public String listarDadosNota(Model model){
        List<CursoNota> notas = notaService.obtemListaNotas();
        model.addAttribute("notas", notas);
        return "/consultas/consultaNota";
    }

    @GetMapping("/editar/{id}")
    public String editarNota(@PathVariable("id") Integer id, Model model) {
        List<EstudanteCurso> estudantes = estudanteService.obtemListaEstudante();
        model.addAttribute("estudantes", estudantes);
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        Optional<CursoNota> nota = notaService.buscarPorIdNota(id);
        model.addAttribute("nota", nota.get());
        return "/cadastros/cadastroNota";
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarNota(@PathVariable("id") Integer id){
        try {
            notaService.deletarNota(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Deletar o registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }
}
