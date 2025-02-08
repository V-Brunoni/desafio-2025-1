package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.model.EstudanteCurso;
import br.edu.unoesc.desafio_2025_1.model.Pessoa;
import br.edu.unoesc.desafio_2025_1.model.Situacao;
import br.edu.unoesc.desafio_2025_1.repository.CursoRepository;
import br.edu.unoesc.desafio_2025_1.repository.EstudanteCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EstudanteCursoService {

    @Autowired
    private EstudanteCursoRepository repository;
    private CursoRepository cursoRepository;

    public void associarEstudanteCurso(Pessoa estudante, Curso curso) {
        if (curso.getSituacao() != Situacao.ATIVO) {
            throw new RuntimeException("Não é possível associar a cursos inativos.");
        }

        EstudanteCurso estudanteCurso = new EstudanteCurso();
        estudanteCurso.setEstudante(estudante);
        estudanteCurso.setCurso(curso);

        repository.save(estudanteCurso);
    }
}
