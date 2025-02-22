package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.*;
import br.edu.unoesc.desafio_2025_1.repository.EstudanteCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteCursoService {

    @Autowired
    private EstudanteCursoRepository repositorio;

    public EstudanteCurso cadastrarEstudante(EstudanteCurso estudante) {
        Curso curso = estudante.getCurso();
        if (curso.getSituacao() != Situacao.ATIVO) {
            throw new RuntimeException("O curso precisa estar com a situação ATIVO para cadastrar o estudante.");
        }
        return repositorio.save(estudante);
    }

    public List<EstudanteCurso> obtemListaEstudante() {
        return repositorio.findAll();
    }

    public Optional<EstudanteCurso> buscarPorIdEstudante(Integer id) {
        return repositorio.findById(id);
    }

    public void deletarEstudante(Integer id) {
        Optional<EstudanteCurso> estudante = buscarPorIdEstudante(id);
        if (estudante.isPresent()) {
            repositorio.delete(estudante.get());
        }
    }
}
