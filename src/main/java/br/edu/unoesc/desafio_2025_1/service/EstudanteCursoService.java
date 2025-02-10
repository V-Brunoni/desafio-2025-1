package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.*;
import br.edu.unoesc.desafio_2025_1.repository.CursoRepository;
import br.edu.unoesc.desafio_2025_1.repository.EstudanteCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteCursoService {

    @Autowired
    private EstudanteCursoRepository repositorio;
    @Autowired
    private CursoRepository cursoRepository;

    public EstudanteCurso cadastrarEstudante(EstudanteCurso estudante){
        return repositorio.save(estudante);
    }

    public List<EstudanteCurso> obtemListaEstudante(){
        return repositorio.findAll();
    }

    public Optional<EstudanteCurso> buscarPorIdEstudante(Integer id){
        return repositorio.findById(id);
    }

    public void deletarEstudante(Integer id){
        Optional<EstudanteCurso> estudante = buscarPorIdEstudante(id);
        if (estudante.isPresent()) {
            repositorio.delete(estudante.get());
        }
    }


//    public void associarEstudanteCurso(Pessoa estudante, Curso curso) {
//        if (curso.getSituacao() != Situacao.ATIVO) {
//            throw new RuntimeException("Não é possível associar a cursos inativos.");
//        }
//
//        EstudanteCurso estudanteCurso = new EstudanteCurso();
//        estudanteCurso.setEstudante(estudante);
//        estudanteCurso.setCurso(curso);
//
//        repositorio.save(estudanteCurso);
//    }
}
