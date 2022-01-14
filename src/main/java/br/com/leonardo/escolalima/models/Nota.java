package br.com.leonardo.escolalima.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Nota {
    private Double valor;

    public Nota() {
    }

    public Nota(Double valor) {
        this.valor = valor;
    }
}
