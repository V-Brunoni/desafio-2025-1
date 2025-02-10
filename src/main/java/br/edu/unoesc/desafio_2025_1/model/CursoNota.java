package br.edu.unoesc.desafio_2025_1.model;

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
    private int id;

    private Double nota;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private EstudanteCurso estudante;

    public CursoNota(int id, Double nota, Curso curso, EstudanteCurso estudante) {
        this.id = id;
        this.nota = nota;
        this.curso = curso;
        this.estudante = estudante;
    }
}
