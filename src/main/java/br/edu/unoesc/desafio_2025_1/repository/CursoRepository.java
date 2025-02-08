package br.edu.unoesc.desafio_2025_1.repository;

import br.edu.unoesc.desafio_2025_1.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
