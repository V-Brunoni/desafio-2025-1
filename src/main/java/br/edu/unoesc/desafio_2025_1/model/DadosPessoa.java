package br.edu.unoesc.desafio_2025_1.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosPessoa(@JsonAlias("first") String primeiroNome,
                          @JsonAlias("last") String sobrenome,
                          @JsonAlias("email") String email,
                          @JsonAlias("phone") String telefone) {


    public String getNomeCompleto() {
        return primeiroNome + " " + sobrenome;
    }
}





