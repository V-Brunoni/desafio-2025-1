package br.edu.unoesc.desafio_2025_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoaEndereco")
public class PessoaEndereco {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cidade;

    private String cep;

    private String rua;

    private int numero;

    private Pessoa pessoa;

    public PessoaEndereco(int id, String cidade, String cep, String rua, int numero, Pessoa pessoa) {
        this.id = id;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
