package br.edu.unoesc.desafio_2025_1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Integer id;

    private Integer quantidade;

    @ManyToOne
    @JsonBackReference
    private Curso curso;

    @ManyToOne
    @JsonBackReference
    private EstudanteCurso estudante;

    public CursoPresenca(EstudanteCurso estudante, Curso curso, Integer quantidade, Integer id) {
        this.estudante = estudante;
        this.curso = curso;
        this.quantidade = quantidade;
        this.id = id;
    }
}
