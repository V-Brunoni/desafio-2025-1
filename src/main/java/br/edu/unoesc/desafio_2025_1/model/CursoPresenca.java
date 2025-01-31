package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursoPresencas")
public class CursoPresenca {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Curso curso;

    private EstudanteCurso estudante;

    public CursoPresenca(int id, Curso curso, EstudanteCurso estudante) {
        this.id = id;
        this.curso = curso;
        this.estudante = estudante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public EstudanteCurso getEstudante() {
        return estudante;
    }

    public void setEstudante(EstudanteCurso estudante) {
        this.estudante = estudante;
    }
}
