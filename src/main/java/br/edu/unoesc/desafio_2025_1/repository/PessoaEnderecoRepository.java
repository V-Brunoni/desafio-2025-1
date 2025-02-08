package br.edu.unoesc.desafio_2025_1.repository;

import br.edu.unoesc.desafio_2025_1.model.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Integer> {
}
