package br.edu.unoesc.desafio_2025_1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Integer id;

    @ManyToOne
    @JsonBackReference
    private Pessoa professor;

    @ManyToOne
    @JsonBackReference
    private Curso curso;

    public ProfessorCurso(Integer id, Pessoa professor, Curso curso) {
        this.id = id;
        this.professor = professor;
        this.curso = curso;
    }

}
