package br.edu.unoesc.desafio_2025_1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(unique = true)
    private String cpf;

    private boolean ativo;

    private String nomeCompleto;

    @JsonProperty("first")
    @Transient
    private String primeiroNome;

    @JsonProperty("last")
    @Transient
    private String sobrenome;

    @JsonProperty("email")
    //@Column(unique = true)
    private String email;

    @JsonProperty("phone")
    //@Column(unique = true)
    private String telefone;

    //@Column(unique = true)
    private String usuario;

    //@Column(unique = true)
    private String senha;

    @OneToOne(mappedBy = "pessoa")
    private PessoaEndereco pessoaEndereco;

    @OneToMany(mappedBy = "professor")
    private List<ProfessorCurso> professores = new ArrayList<>();

    @OneToMany(mappedBy = "estudante")
    private List<EstudanteCurso> estudantes = new ArrayList<>();

    public Pessoa(Integer id, String cpf, boolean ativo, String usuario, String senha){
        this.id = id;
        this.cpf = cpf;
        this.ativo = ativo;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Pessoa(DadosPessoa dadosPessoa) {
        this.nomeCompleto = dadosPessoa.getNomeCompleto();
        this.email = dadosPessoa.email();
        this.telefone = dadosPessoa.telefone();
    }



}
