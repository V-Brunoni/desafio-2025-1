package br.edu.unoesc.desafio_2025_1.controller;


import br.edu.unoesc.desafio_2025_1.model.Pessoa;
import br.edu.unoesc.desafio_2025_1.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
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
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/cadastro")
    public String getPessoas(Model model){
        Pessoa pessoa = pessoaService.obtemDadosAPIParaPessoas();
        model.addAttribute(pessoa);
        return "/cadastros/cadastroPessoa";
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarPessoa(@Validated @ModelAttribute Pessoa pessoa, BindingResult result){
        try {
            if(result.hasErrors()){
                Map<String, String> erros = new HashMap<>();
                result.getFieldErrors().forEach(t->{
                    erros.put(t.getField(), t.getDefaultMessage());
                });
                return ResponseEntity.badRequest().body(erros);
            }
            Pessoa pessoaSalva = pessoaService.cadastrarPessoa(pessoa);
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
        }catch (Exception e){
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Salvar o registro");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

    @GetMapping("/listarDados")
    public String listarDadosPessoa(Model model){
        List<Pessoa> pessoas = pessoaService.obtemListaPessoas();
        model.addAttribute("pessoas", pessoas);
        return "/consultas/consultaPessoa";
    }


    @GetMapping("/editar/{id}")
    public String editarPessoa(@PathVariable("id") Integer id, Model model) {
        Optional<Pessoa> pessoa = pessoaService.buscarPorIdPessoa(id);
        model.addAttribute("pessoa", pessoa.get());
        model.addAttribute("editando", "true");
        return "/cadastros/cadastroPessoa";
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPessoa(@PathVariable("id") Integer id){
        try {
            pessoaService.deletarPessoa(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Deletar o registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }



}






