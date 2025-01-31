package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeCurso")
    private String nome;

    private String assunto;

    private int encontros;

    private String situacao;

    public Curso(int id, String nome, String assunto, int encontros, String situacao) {
        this.id = id;
        this.nome = nome;
        this.assunto = assunto;
        this.encontros = encontros;
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public int getEncontros() {
        return encontros;
    }

    public void setEncontros(int encontros) {
        this.encontros = encontros;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
