package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.PessoaEndereco;
import br.edu.unoesc.desafio_2025_1.repository.PessoaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaEnderecoService {

    @Autowired
    private PessoaEnderecoRepository repositorio;

    public PessoaEndereco cadastrarEndereco(PessoaEndereco endereco){
        return repositorio.save(endereco);
    }

    public List<PessoaEndereco> obtemListaEnderecos(){
        return repositorio.findAll();
    }

    public Optional<PessoaEndereco> buscarPorIdEndereco(Integer id){
        return repositorio.findById(id);
    }

    public void deletarEndereco(Integer id){
        Optional<PessoaEndereco> endereco = buscarPorIdEndereco(id);
        if (endereco.isPresent()) {
            repositorio.delete(endereco.get());
        }
    }
}
