package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudantes")
@Getter
@Setter
@NoArgsConstructor
public class EstudanteCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Pessoa estudante;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "estudante")
    private List<CursoNota> notas = new ArrayList<>();

    @OneToMany(mappedBy = "estudante")
    private List<CursoPresenca> presencas = new ArrayList<>();

    public EstudanteCurso(int id, Pessoa estudante, Curso curso) {
        this.id = id;
        this.estudante = estudante;
        this.curso = curso;
    }

}
