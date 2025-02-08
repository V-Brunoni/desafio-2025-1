package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "professores")
@Getter
@Setter
@NoArgsConstructor
public class ProfessorCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Pessoa professor;

    @ManyToOne
    private Curso curso;

    public ProfessorCurso(int id, Pessoa professor, Curso curso) {
        this.id = id;
        this.professor = professor;
        this.curso = curso;
    }

}
