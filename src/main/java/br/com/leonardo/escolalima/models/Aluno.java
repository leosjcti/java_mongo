package br.com.leonardo.escolalima.models;

import java.util.ArrayList;
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

    public List<Habilidade> getHabilidades() {
        if(habilidades == null){
            habilidades = new ArrayList<Habilidade>();
        }
        return habilidades;
    }

    public List<Nota> getNotas() {
        if(notas == null) {
            notas = new ArrayList<Nota>();
        }
        return notas;
    }

    public Aluno criarId() {
        setId(new ObjectId());
        return this;
    }

    public Aluno adiciona(Aluno aluno, Habilidade habilidade) {
        List<Habilidade> habilidades = aluno.getHabilidades();
        habilidades.add(habilidade);
        aluno.setHabilidades(habilidades);
        return aluno;
    }

    public Aluno adicionar(Aluno aluno, Nota nota) {
        List<Nota> notas = aluno.getNotas();
        notas.add(nota);
        aluno.setNotas(notas);
        return aluno;
    }
}
