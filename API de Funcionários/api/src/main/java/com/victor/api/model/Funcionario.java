package com.victor.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    // este campo identifica o atributo com id primary key
    // o abaixo: id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String setor;
    private int idade;

    public Funcionario(){}

    public Funcionario(String nome, String setor, int idade) {
        this.nome = nome;
        this.setor = setor;
        this.idade = idade;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    public int getIdade() {
        return idade;
    }
}
