package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomeCurso")
    private String nome;

    @Column(name = "assuntoCurso")
    private String assunto;

    private Integer encontros;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @OneToMany(mappedBy = "curso")
    private List<ProfessorCurso> professores = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<CursoNota> notas = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<CursoPresenca> presencas = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<EstudanteCurso> estudantes = new ArrayList<>();

    public Curso(Integer id, String nome, String assunto, Integer encontros, Situacao situacao) {
        this.id = id;
        this.nome = nome;
        this.assunto = assunto;
        this.encontros = encontros;
        this.situacao = situacao;
    }
}
