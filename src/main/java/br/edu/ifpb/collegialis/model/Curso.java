package br.edu.ifpb.collegialis.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_sequence")
    @SequenceGenerator(name = "curso_sequence", sequenceName = "curso_seq_id", initialValue = 3, allocationSize = 1)
    private Long id;

    private String descricao;

    @OneToOne
    private Coordenacao coordenacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Coordenacao getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(Coordenacao coordenacao) {
        this.coordenacao = coordenacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        Curso other = (Curso) obj;
        return this.id == other.id;
    }

}
