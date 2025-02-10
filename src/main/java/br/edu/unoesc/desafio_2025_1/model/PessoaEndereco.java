package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoaEndereco")
@Getter
@Setter
@NoArgsConstructor
public class PessoaEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cidade;

    private String cep;

    private String rua;

    private Integer numero;

    @OneToOne
    private Pessoa pessoa;

    public PessoaEndereco(Integer id, String cidade, String cep, String rua, Integer numero, Pessoa pessoa) {
        this.id = id;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.pessoa = pessoa;
    }

}
