package br.com.leonardo.escolalima.codecs;

import java.util.Date;

import br.com.leonardo.escolalima.models.Aluno;
import br.com.leonardo.escolalima.models.Curso;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.types.ObjectId;

public class AlunoCodec implements CollectibleCodec<Aluno> {

    private Codec<Document> codec;

    public AlunoCodec(Codec<Document> codec) {
        this.codec = codec;
    }

    @Override
    public Aluno generateIdIfAbsentFromDocument(Aluno aluno) {
        return documentHasId(aluno) ? aluno.criarId() : aluno;
    }

    @Override
    public boolean documentHasId(Aluno aluno) {
        return aluno.getId() == null;
    }

    @Override
    public BsonValue getDocumentId(Aluno aluno) {
        if(!documentHasId(aluno)) {
            throw new IllegalStateException("This document has not ID");
        }
        return new BsonString(aluno.getId().toHexString());
    }

    @Override
    public Aluno decode(BsonReader bsonReader, DecoderContext decoderContext) {
        return null;
    }

    @Override
    public void encode(BsonWriter writer, Aluno aluno, EncoderContext encoder) {
        ObjectId id = aluno.getId();
        String nome = aluno.getNome();
        Date dataNascimento = aluno.getDataNascimento();
        Curso curso = aluno.getCurso();

        Document documento = new Document();
        documento.put("_id", id);
        documento.put("nome", nome);
        documento.put("data_nascimento", dataNascimento);
        documento.put("curso", new Document("nome", curso.getNome()));

        codec.encode(writer, documento, encoder);
    }

    @Override
    public Class<Aluno> getEncoderClass() {
        return Aluno.class;
    }
}