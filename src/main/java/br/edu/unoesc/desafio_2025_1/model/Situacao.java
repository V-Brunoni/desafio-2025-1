package br.edu.unoesc.desafio_2025_1.model;

public enum Situacao {
    ATIVO("Ativo"),
    INATIVO("Inativo");


    private String situacaoCurso;

    Situacao(String situacaoCurso) {
        this.situacaoCurso = situacaoCurso;
    }

}
