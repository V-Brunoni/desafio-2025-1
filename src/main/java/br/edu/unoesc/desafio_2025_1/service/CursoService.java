package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Curso> buscarPorIdCurso(Integer id){
        return repositorio.findById(id);
    }

    public void deletarCurso(Integer id){
        Optional<Curso> curso = buscarPorIdCurso(id);
        if (curso.isPresent()) {
            repositorio.delete(curso.get());
        }
    }
}
