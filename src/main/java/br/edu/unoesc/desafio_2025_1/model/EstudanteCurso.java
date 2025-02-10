package br.edu.unoesc.desafio_2025_1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Pessoa estudante;

    @ManyToOne
    @JsonBackReference
    private Curso curso;

    @OneToMany(mappedBy = "estudante")
    @JsonManagedReference
    private List<CursoNota> notas = new ArrayList<>();

    @OneToMany(mappedBy = "estudante")
    @JsonManagedReference
    private List<CursoPresenca> presencas = new ArrayList<>();

    public EstudanteCurso(Integer id, Pessoa estudante, Curso curso) {
        this.id = id;
        this.estudante = estudante;
        this.curso = curso;
    }

}
