package br.com.leonardo.escolalima.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Curso {
    private String nome;

    public Curso(){}

    public Curso(String nome) {
        this.nome = nome;
    }
}