package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.CursoNota;
import br.edu.unoesc.desafio_2025_1.repository.CursoNotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoNotaService {

    @Autowired
    private CursoNotaRepository repositorio;

    public CursoNota cadastrarNota(CursoNota nota){
        return repositorio.save(nota);
    }

    public List<CursoNota> obtemListaNotas(){
        return repositorio.findAll();
    }

    public Optional<CursoNota> buscarPorIdNota(Integer id){
        return repositorio.findById(id);
    }

    public void deletarNota(Integer id){
        Optional<CursoNota> nota = buscarPorIdNota(id);
        if (nota.isPresent()) {
            repositorio.delete(nota.get());
        }
    }
}
