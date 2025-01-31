package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudanteCurso")
public class EstudanteCurso {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Pessoa estudante;

    private Curso curso;

    public EstudanteCurso(int id, Pessoa estudante, Curso curso) {
        this.id = id;
        this.estudante = estudante;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getEstudante() {
        return estudante;
    }

    public void setEstudante(Pessoa estudante) {
        this.estudante = estudante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
