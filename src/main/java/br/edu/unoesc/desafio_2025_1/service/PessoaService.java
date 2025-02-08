package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.Pessoa;
import br.edu.unoesc.desafio_2025_1.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repositorio;

    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return repositorio.save(pessoa);
    }


}
