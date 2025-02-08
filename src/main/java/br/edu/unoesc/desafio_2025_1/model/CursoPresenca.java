package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "presencas")
@Getter
@Setter
@NoArgsConstructor
public class CursoPresenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private EstudanteCurso estudante;

    public CursoPresenca(int id, Curso curso, EstudanteCurso estudante) {
        this.id = id;
        this.curso = curso;
        this.estudante = estudante;
    }

}
