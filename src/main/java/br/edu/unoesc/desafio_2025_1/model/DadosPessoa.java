package br.edu.unoesc.desafio_2025_1.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosPessoa(@JsonAlias({"first" + "last"}) String nome,
                          @JsonAlias("email") String email,
                          @JsonAlias("phone") String telefone) {
}
