package br.com.leonardo.escolalima.models;

import java.util.Date;
import java.util.List;

import lombok.ToString;
import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter @Setter @ToString
public class Aluno {
    private ObjectId id;
    private String nome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    private Curso curso;
    private List<Nota> notas;
    private List<Habilidade> habilidades;

    public Aluno criarId() {
        setId(new ObjectId());
        return this;
    }
}
