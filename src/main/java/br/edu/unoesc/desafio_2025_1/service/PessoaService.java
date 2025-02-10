package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.DadosPessoa;
import br.edu.unoesc.desafio_2025_1.model.Pessoa;
import br.edu.unoesc.desafio_2025_1.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repositorio;
    private final String ENDERECO = "https://randomuser.me/api/";
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteJSON converte = new ConverteJSON();

    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return repositorio.save(pessoa);
    }

    private DadosPessoa getPreencherDadosPessoaAPI() {
        var json = consumo.obterDados(ENDERECO);
        return converte.obterDados(json, DadosPessoa.class);
    }

    public Pessoa obtemDadosAPIParaPessoas() {
        DadosPessoa dados = getPreencherDadosPessoaAPI();
        return new Pessoa(dados);
    }

    public List<Pessoa> obtemListaPessoas(){
        return repositorio.findAll();
    }

    public Optional<Pessoa> buscarPorIdPessoa(Integer id){
        return repositorio.findById(id);
    }

    public void deletarPessoa(Integer id){
        Optional<Pessoa> pessoa = buscarPorIdPessoa(id);
        if (pessoa.isPresent()) {
            repositorio.delete(pessoa.get());
        }
    }


}
