package br.edu.unoesc.desafio_2025_1.repository;

import br.edu.unoesc.desafio_2025_1.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
