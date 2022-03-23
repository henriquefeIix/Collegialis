package br.edu.ifpb.collegialis.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_seq_id", initialValue = 21, allocationSize = 1)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String telefone;

    @Column(unique = true)
    private String matricula;

    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public boolean equals(Object obj) {
        Usuario other = (Usuario) obj;
        return this.matricula == other.matricula;
    }

    public boolean isAdministrador() {
        return this instanceof Administrador;
    }

    public boolean isAluno() {
        return this instanceof Aluno;
    }

    public boolean isCoordenador() {
        if (this instanceof Professor) {
            return ((Professor) this).getCoordenacao() != null;
        } else {
            return false;
        }
    }

    public boolean isProfessor() {
        return this instanceof Professor;
    }

}
