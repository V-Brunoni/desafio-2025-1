package br.edu.unoesc.desafio_2025_1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notas")
@Getter
@Setter
@NoArgsConstructor
public class CursoNota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double notas;

    @ManyToOne
    @JsonBackReference
    private Curso curso;

    @ManyToOne
    @JsonBackReference
    private EstudanteCurso estudante;

    public CursoNota(Integer id, Double notas, Curso curso, EstudanteCurso estudante) {
        this.id = id;
        this.notas = notas;
        this.curso = curso;
        this.estudante = estudante;
    }
}
