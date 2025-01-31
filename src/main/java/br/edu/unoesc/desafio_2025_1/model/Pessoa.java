package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cpf;

    private boolean ativo;

    private String nome;

    private String email;

    private String telefone;

    private String usuario;

    private String senha;

    public Pessoa(DadosPessoa dadosPessoa){
        this.nome = dadosPessoa.nome();
        this.email = dadosPessoa.email();
        this.telefone = dadosPessoa.telefone();
    }

    public Pessoa(int id, String cpf, boolean ativo, String usuario, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.ativo = ativo;
        this.usuario = usuario;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
