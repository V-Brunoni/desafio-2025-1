package br.edu.unoesc.desafio_2025_1.service;


import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.model.CursoPresenca;
import br.edu.unoesc.desafio_2025_1.model.Situacao;
import br.edu.unoesc.desafio_2025_1.repository.CursoPresencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoPresencaService {

    @Autowired
    private CursoPresencaRepository repositorio;

    public CursoPresenca cadastrarPresenca(CursoPresenca presenca){
        return repositorio.save(presenca);
    }

    public List<CursoPresenca> obtemListaPresenca(){
        return repositorio.findAll();
    }

    public Optional<CursoPresenca> buscarPorIdPresenca(Integer id){
        return repositorio.findById(id);
    }

    public void deletarPresenca(Integer id){
        Optional<CursoPresenca> presencaOpt = buscarPorIdPresenca(id);
        if (presencaOpt.isPresent()) {
            CursoPresenca presenca = presencaOpt.get();
            Curso curso = presenca.getCurso();
            if (curso.getSituacao() == Situacao.ATIVO) {
                repositorio.delete(presenca);
            } else {
                throw new RuntimeException();
            }
        } else {
            throw new RuntimeException();
        }
    }
}
