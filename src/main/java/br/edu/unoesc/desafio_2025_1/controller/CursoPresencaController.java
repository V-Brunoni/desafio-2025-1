package br.edu.unoesc.desafio_2025_1.controller;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.model.CursoPresenca;
import br.edu.unoesc.desafio_2025_1.model.EstudanteCurso;
import br.edu.unoesc.desafio_2025_1.service.CursoPresencaService;
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
@RequestMapping("/presenca")
public class CursoPresencaController {

    @Autowired
    private CursoPresencaService presencaService;
    @Autowired
    private EstudanteCursoService estudanteService;
    @Autowired
    private CursoService cursoService;

    @GetMapping("/cadastro")
    public String getPresencas(@ModelAttribute("presenca")CursoPresenca presenca, Model model){
        List<EstudanteCurso> estudantes = estudanteService.obtemListaEstudante();
        model.addAttribute("estudantes", estudantes);
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        return "/cadastros/cadastroPresenca";
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarPresenca(@Validated @ModelAttribute CursoPresenca presenca, BindingResult result){
        try {
            if(result.hasErrors()){
                Map<String, String> erros = new HashMap<>();
                result.getFieldErrors().forEach(t->{
                    erros.put(t.getField(), t.getDefaultMessage());
                });
                return ResponseEntity.badRequest().body(erros);
            }
            CursoPresenca presencaSalva = presencaService.cadastrarPresenca(presenca);
            return ResponseEntity.status(HttpStatus.CREATED).body(presencaSalva);
        }catch (Exception e){
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Salvar o registro");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

    @GetMapping("/listarDados")
    public String listarDadosPresenca(Model model){
        List<CursoPresenca> presencas = presencaService.obtemListaPresenca();
        model.addAttribute("presencas", presencas);
        return "/consultas/consultaPresenca";
    }

    @GetMapping("/editar/{id}")
    public String editarPresenca(@PathVariable("id") Integer id, Model model) {
        List<EstudanteCurso> estudantes = estudanteService.obtemListaEstudante();
        model.addAttribute("estudantes", estudantes);
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        Optional<CursoPresenca> presenca = presencaService.buscarPorIdPresenca(id);
        model.addAttribute("presenca", presenca.get());
        return "/cadastros/cadastroPresenca";
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPresenca(@PathVariable("id") Integer id){
        try {
            presencaService.deletarPresenca(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Deletar o registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }
}
