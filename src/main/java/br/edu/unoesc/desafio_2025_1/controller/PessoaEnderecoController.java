package br.edu.unoesc.desafio_2025_1.controller;


import br.edu.unoesc.desafio_2025_1.model.Pessoa;
import br.edu.unoesc.desafio_2025_1.model.PessoaEndereco;
import br.edu.unoesc.desafio_2025_1.service.PessoaEnderecoService;
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
@RequestMapping("/endereco")
public class PessoaEnderecoController {

    @Autowired
    private PessoaEnderecoService enderecoService;
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/cadastro")
    public String getEnderecos(@ModelAttribute("endereco") PessoaEndereco endereco, Model model){
        List<Pessoa> pessoas = pessoaService.obtemListaPessoas();
        model.addAttribute("pessoas", pessoas);
        return "/cadastros/cadastroEndereco";
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvarEndereco(@Validated @ModelAttribute PessoaEndereco endereco, BindingResult result){
        try {
            if(result.hasErrors()){
                Map<String, String> erros = new HashMap<>();
                result.getFieldErrors().forEach(t->{
                    erros.put(t.getField(), t.getDefaultMessage());
                });
                return ResponseEntity.badRequest().body(erros);
            }
            PessoaEndereco enderecoSalvo = enderecoService.cadastrarEndereco(endereco);
            return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSalvo);
        }catch (Exception e){
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Salvar o registro");
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }

    @GetMapping("/listarDados")
    public String listarDadosEndereco(Model model){
        List<PessoaEndereco> enderecos = enderecoService.obtemListaEnderecos();
        model.addAttribute("enderecos", enderecos);
        return "/consultas/consultaEndereco";
    }

    @GetMapping("/editar/{id}")
    public String editarEndereco(@PathVariable("id") Integer id, Model model) {
        List<Pessoa> pessoas = pessoaService.obtemListaPessoas();
        model.addAttribute("pessoas", pessoas);
        Optional<PessoaEndereco> endereco = enderecoService.buscarPorIdEndereco(id);
        model.addAttribute("endereco", endereco.get());
        //model.addAttribute("editando", "true");
        return "/cadastros/cadastroEndereco";
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable("id") Integer id){
        try {
            enderecoService.deletarEndereco(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("erro", "Ocorreu um problema ao Deletar o registro");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
        }
    }
}
