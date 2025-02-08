package br.edu.unoesc.desafio_2025_1.model;

public enum Situacao {
    ATIVO("Ativo"),
    INATIVO("Inativo");


    private String situacaoCurso;

    Situacao(String situacaoCurso) {
        this.situacaoCurso = situacaoCurso;
    }

    public static Situacao fromString(String text) {
        for (Situacao situacao : Situacao.values()) {
            if (situacao.situacaoCurso.equalsIgnoreCase(text)) {
                return situacao;
            }
        }
        throw new IllegalArgumentException("Nenhuma situação encontrada para a string fornecida: " + text);
    }

}
