package br.edu.ifpb.collegialis.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.edu.ifpb.collegialis.enumeration.DecisaoTipo;
import br.edu.ifpb.collegialis.enumeration.ProcessoStatus;

@Entity
public class Processo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "processo_sequence")
    @SequenceGenerator(name = "processo_sequence", sequenceName = "processo_seq_id", initialValue = 11, allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String numero;

    private String parecer;

    @Column(nullable = true)
    private String requerimento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRecepcao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDistribuicao;

    @OneToOne
    private Assunto assunto;

    @Temporal(TemporalType.DATE)
    private Date dataParecer;

    @Enumerated(EnumType.STRING)
    private DecisaoTipo decisao;

    @Enumerated(EnumType.STRING)
    private ProcessoStatus status;

    @ManyToOne
    private Professor relator;

    @ManyToOne
    @NotNull(message = "A escolha do requisitante do processo é obrigatória.")
    private Aluno requisitante;

    @ManyToOne
    private Reuniao reuniao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public String getRequerimento() {
        return requerimento;
    }

    public void setRequerimento(String requerimento) {
        this.requerimento = requerimento;
    }

    public Date getDataRecepcao() {
        return dataRecepcao;
    }

    public void setDataRecepcao(Date dataRecepcao) {
        this.dataRecepcao = dataRecepcao;
    }

    public Date getDataDistribuicao() {
        return dataDistribuicao;
    }

    public void setDataDistribuicao(Date dataDistribuicao) {
        this.dataDistribuicao = dataDistribuicao;
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public Date getDataParecer() {
        return dataParecer;
    }

    public void setDataParecer(Date dataParecer) {
        this.dataParecer = dataParecer;
    }

    public DecisaoTipo getDecisao() {
        return decisao;
    }

    public void setDecisao(DecisaoTipo decisao) {
        this.decisao = decisao;
    }

    public ProcessoStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessoStatus status) {
        this.status = status;
    }

    public Professor getRelator() {
        return relator;
    }

    public void setRelator(Professor relator) {
        this.relator = relator;
    }

    public Aluno getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(Aluno requisitante) {
        this.requisitante = requisitante;
    }

    public Reuniao getReuniao() {
        return reuniao;
    }

    public void setReuniao(Reuniao reuniao) {
        this.reuniao = reuniao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        Processo other = (Processo) obj;
        return this.id == other.id;
    }

}
