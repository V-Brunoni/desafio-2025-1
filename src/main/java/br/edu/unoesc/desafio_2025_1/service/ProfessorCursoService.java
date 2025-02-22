package br.edu.unoesc.desafio_2025_1.service;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import br.edu.unoesc.desafio_2025_1.model.ProfessorCurso;
import br.edu.unoesc.desafio_2025_1.model.Situacao;
import br.edu.unoesc.desafio_2025_1.repository.ProfessorCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorCursoService {

    @Autowired
    private ProfessorCursoRepository repositorio;

    public ProfessorCurso cadastrarProfessor(ProfessorCurso professor){
        Curso curso = professor.getCurso();
        if (curso.getSituacao() != Situacao.ATIVO) {
            throw new RuntimeException("O curso precisa estar com a situação ATIVO para cadastrar o professor.");
        }
        return repositorio.save(professor);
    }

    public List<ProfessorCurso> obtemListaProfessor(){
        return repositorio.findAll();
    }

    public Optional<ProfessorCurso> buscarPorIdProfessor(Integer id){
        return repositorio.findById(id);
    }

    public void deletarProfessor(Integer id){
        Optional<ProfessorCurso> professor = buscarPorIdProfessor(id);
        if (professor.isPresent()) {
            repositorio.delete(professor.get());
        }
    }
}
