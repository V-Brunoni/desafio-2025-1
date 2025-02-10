package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repositorio;

    public Curso cadastrarCurso(Curso curso){
        return repositorio.save(curso);
    }

    public List<Curso> obtemListaCursos(){
        return repositorio.findAll();
    }
}
