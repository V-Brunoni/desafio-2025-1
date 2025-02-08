package br.edu.unoesc.desafio_2025_1.repository;

import br.edu.unoesc.desafio_2025_1.model.EstudanteCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteCursoRepository extends JpaRepository<EstudanteCurso, Integer> {
}
