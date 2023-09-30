package com.example.amigostutorial;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Trabalhador {

    @Id
    @SequenceGenerator(
            name = "professor_id_sequence",
            sequenceName = "professor_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "professor_id_sequence"
    )
    private Integer id;
    private String nome;
    private String profissao;
    private Integer idade;

    public Trabalhador(Integer id, String nome, String profissao, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.idade = idade;
    }

    public Trabalhador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trabalhador that = (Trabalhador) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(profissao, that.profissao) && Objects.equals(idade, that.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, profissao, idade);
    }

    @Override
    public String toString() {
        return "Trabalhador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                ", idade=" + idade +
                '}';
    }
}
