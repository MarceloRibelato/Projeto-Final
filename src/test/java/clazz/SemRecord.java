package clazz;

import java.util.Objects;

public class SemRecord {

    private String nome;

    //Construtor
    public SemRecord(String nome) {
        this.nome = nome;
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemRecord semRecord = (SemRecord) o;
        return Objects.equals(nome, semRecord.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "SemRecord{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
