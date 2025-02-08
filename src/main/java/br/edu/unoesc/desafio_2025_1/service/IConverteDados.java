package br.edu.unoesc.desafio_2025_1.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
