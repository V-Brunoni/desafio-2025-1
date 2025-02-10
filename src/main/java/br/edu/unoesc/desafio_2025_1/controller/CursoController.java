package br.edu.unoesc.desafio_2025_1.controller;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.service.CursoService;
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
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("/cadastro")
    public String getCursos(Model model){
        Curso curso = new Curso();
        model.addAttribute("curso", curso);
        return "/cadastros/cadastroCurso";
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarCurso(@Validated @ModelAttribute Curso curso, BindingResult result){
        try {
            if(result.hasErrors()){
                Map<String, String> erros = new HashMap<>();
                result.getFieldErrors().forEach(t->{
                    erros.put(t.getField(), t.getDefaultMessage());
                });
                return ResponseEntity.badRequest().body(erros);
            }
            Curso cursoSalvo = cursoService.cadastrarCurso(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
        }catch (Exception e){
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Salvar o registro");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

    @GetMapping("/listarDados")
    public String listarDadosCurso(Model model){
        List<Curso> cursos = cursoService.obtemListaCursos();
        model.addAttribute("cursos", cursos);
        return "/consultas/consultaCurso";
    }

    @GetMapping("/editar/{id}")
    public String editarCurso(@PathVariable("id") Integer id, Model model) {
        Optional<Curso> curso = cursoService.buscarPorIdCurso(id);
        model.addAttribute("curso", curso.get());
        //model.addAttribute("editando", "true");
        return "/cadastros/cadastroCurso";
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarCurso(@PathVariable("id") Integer id){
        try {
            cursoService.deletarCurso(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Deletar o registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

}
