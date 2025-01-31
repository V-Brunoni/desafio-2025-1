package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professorCurso")
public class ProfessorCurso {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Pessoa professor;

    private Curso curso;

    public ProfessorCurso(int id, Pessoa professor, Curso curso) {
        this.id = id;
        this.professor = professor;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getProfessor() {
        return professor;
    }

    public void setProfessor(Pessoa professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
